package com.djxiao.app_retrofit.network;

import android.content.Context;
import android.content.Intent;

import com.djxiao.app_retrofit.api.ApiService;
import com.djxiao.app_retrofit.utils.StringConverterFatory;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * @author djxiao
 * @create 2016/7/4 17:15
 * @DESC
 */
public class RetrofitUtil {

    private final static String BASE_URL = "http://2-3.ysctest.kuaidiantong.cn";

    private static RetrofitUtil instance;

    private Retrofit retrofit;
    private ApiService apiService;

    public static RetrofitUtil getInstance(){
        if(instance == null){
            instance = new RetrofitUtil();
        }
        return instance;
    }

    public RetrofitUtil(){
//        retrofit = new Retrofit.Builder()
//                .baseUrl(BASE_URL)
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                .addConverterFactory(GsonConverterFactory.create())
//                .addConverterFactory(StringConverterFatory.create())
//                .build();
//        apiService = retrofit.create(ApiService.class);
    }

    public RetrofitUtil parseByGson(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiService = retrofit.create(ApiService.class);
        return this;
    }

    public RetrofitUtil parseByString(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(StringConverterFatory.create())
                .build();
        apiService = retrofit.create(ApiService.class);
        return this;
    }

    /**
     * 通过Ip获取地址
     */
    public void getAddressByIp(Context context,Subscriber subscriber, String action){

        Observable<String> observable = apiService.getAddressByIp(action);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);

        this.sendOpenProgress(context,true);

    }

    public void sendOpenProgress(Context context,boolean isOpen){
        Intent intent = new Intent(CommuConst.PROGRESS_ACTION);
        intent.setAction(CommuConst.PROGRESS_ACTION);
        intent.putExtra("IsOpen",isOpen);
        context.sendBroadcast(intent);
    }


}
