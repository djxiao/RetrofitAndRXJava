package com.djxiao.app_retrofit.beans;

import android.util.Log;

import com.djxiao.app_retrofit.response.BaseResponse;


/**
 * @author djxiao
 * @create 2016/7/4 15:14
 * @DESC
 */
public abstract class Response extends rx.Subscriber<String> {

    @Override
    public void onCompleted() {
        Log.i("Tag","onCompleted");
    }

    @Override
    public void onError(Throwable e) {
        Log.i("Tag","onError");
    }


}
