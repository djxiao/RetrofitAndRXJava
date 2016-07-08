package com.djxiao.app_retrofit.client;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import com.djxiao.app_retrofit.network.CommuConst;

/**
 * @author djxiao
 * @create 2016/7/7 17:19
 * @DESC
 */
public class App extends Application {

    private onProgressAction listener;

    private MyBroadCastReceiver receiver;
    @Override
    public void onCreate() {
        super.onCreate();

        receiver = new MyBroadCastReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(CommuConst.PROGRESS_ACTION);
        registerReceiver(receiver,filter);
    }

    public void setOnProgressListener(onProgressAction listener){
        this.listener = listener;
    }

    public interface onProgressAction{
        void closeProgress();
        void showProgress();
    }

    public class MyBroadCastReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            boolean isOpen = intent.getBooleanExtra("isOpen",true);
            if(isOpen){
                listener.showProgress();
            }else{
                listener.closeProgress();
            }
        }
    }
}
