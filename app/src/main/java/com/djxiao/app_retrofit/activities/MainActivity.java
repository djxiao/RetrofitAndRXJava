package com.djxiao.app_retrofit.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.djxiao.app_retrofit.R;
import com.djxiao.app_retrofit.network.CommuConst;
import com.djxiao.app_retrofit.network.ResponseFactory;
import com.djxiao.app_retrofit.network.RetrofitUtil;
import com.djxiao.app_retrofit.response.AddressByIpResponse;
import com.djxiao.app_retrofit.suscriber.BaseSubscriber;
import com.djxiao.app_retrofit.utils.LogUtil;

/**
 * @author djxiao
 * @create 2016/7/7 14:47
 * @DESC
 */
public class MainActivity extends BaseActivity{

    private EditText etIp;//输入IP地址
    private Button btnSearch;//查询按钮
    private TextView tvAddress;//显示地址

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registerHeadComponent();
        this.getRightLabel().setText("右侧方法");

        registerComponent();
        this.setHeadTitle("主页");

    }

    @Override
    protected void onRightAciton() {
        showToast("右侧方法");
    }

    private void registerComponent(){

        tvAddress = (TextView) findViewById(R.id.tv_address);
        etIp = (EditText) findViewById(R.id.et_ip);
        btnSearch = (Button) findViewById(R.id.btn_search);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnGetAddressAction();
            }
        });


    }

    private void OnGetAddressAction(){
        RetrofitUtil.getInstance().parseByString().getAddressByIp(this,new BaseSubscriber(this) {
            @Override
            public void onNext(String s) {
                AddressByIpResponse response = (AddressByIpResponse) ResponseFactory.parseAddressByIp(s);
                if(response.getStatueCode() == CommuConst.RESULT_OK){
                    LogUtil.i("成功返回请求");

                    tvAddress.setText(response.country+">>"+response.country_id
                            +">>"+response.area +">>"+response.area_id
                            +">>"+response.region +">>"+response.region_id
                            +">>"+response.city +">>"+response.city_id
                            +">>"+response.county +">>"+response.county_id
                            +">>"+response.isp+">>"+response.isp_id
                            +">>"+response.ip);
                }else{
                    showToast(response.getMsg());
                }
            }
        }, etIp.getText().toString());
    }
}
