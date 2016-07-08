package com.djxiao.app_retrofit.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.djxiao.app_retrofit.R;
import com.djxiao.app_retrofit.client.App;

/**
 * @author djxiao
 * @create 2016/7/4 15:15
 * @DESC  这里是基础的activity，理应所有activity都继承该activity
 * 这里封装了很多公共方法以及网络请求
 */
public class BaseActivity extends AppCompatActivity implements App.onProgressAction {

    private RelativeLayout layoutLeftPanel;
    private RelativeLayout layoutCentrePanel;
    private RelativeLayout layoutRightPanel;
    private TextView tvBack;
    private TextView tvTitle;
    private TextView tvRight;
    private View layoutLoading;
    private View layoutHead;

    private App app;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        app = (App) getApplication();
        app.setOnProgressListener(this);

    }

    protected  void registerHeadComponent(){

        layoutHead = findViewById(R.id.layout_head);
        layoutLoading = findViewById(R.id.layout_loading);

        layoutLeftPanel = (RelativeLayout) findViewById(R.id.layout_left_panel);
        layoutCentrePanel = (RelativeLayout) findViewById(R.id.layout_centre_panel);
        layoutRightPanel = (RelativeLayout) findViewById(R.id.layout_right_panel);
        tvBack = (TextView) findViewById(R.id.tv_bakc);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        tvRight = (TextView) findViewById(R.id.tv_right);

        layoutLeftPanel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackAction();
            }
        });

        layoutRightPanel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onRightAciton();
            }
        });

    }

    protected void closeProgressDialog(){
        layoutLoading.setVisibility(View.GONE);
    }

    protected void showProgressDialog(){
        layoutLoading.setVisibility(View.VISIBLE);
    }

    protected void setHeadTitle(String title){
        tvTitle.setText(title);
    }

    protected void onBackAction(){
        finish();
    }

    protected void onRightAciton(){

    }

    public View getRightPanel(){
        return layoutRightPanel;
    }
    public TextView getRightLabel(){
        return tvRight;
    }

    protected void showToast(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    protected View inflate(int resId){
        return LayoutInflater.from(this).inflate(resId,null);
    }


    @Override
    public void closeProgress() {
        closeProgressDialog();
    }

    @Override
    public void showProgress() {
        showProgressDialog();
    }
}
