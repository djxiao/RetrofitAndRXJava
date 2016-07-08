package com.djxiao.app_retrofit.suscriber;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.djxiao.app_retrofit.network.CommuConst;
import com.djxiao.app_retrofit.utils.LogUtil;


/**
 * @author djxiao
 * @create 2016/7/4 15:14
 * @DESC  这里是基础的观察者，继承自观察者，只需复写onNext方法即可
 */
public abstract class BaseSubscriber extends rx.Subscriber<String> {

    private Context context;
    public BaseSubscriber(Context context){
        this.context = context;
    }

    @Override
    public void onCompleted() {
        Intent intent = new Intent(CommuConst.PROGRESS_ACTION);
        intent.setAction(CommuConst.PROGRESS_ACTION);
        intent.putExtra("isOpen",false);
        context.sendBroadcast(intent);
    }

    @Override
    public void onError(Throwable e) {
        Intent intent = new Intent(CommuConst.PROGRESS_ACTION);
        intent.setAction(CommuConst.PROGRESS_ACTION);
        intent.putExtra("isOpen",false);
        context.sendBroadcast(intent);
    }


}
