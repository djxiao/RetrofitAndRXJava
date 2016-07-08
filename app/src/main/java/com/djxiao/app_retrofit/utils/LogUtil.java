package com.djxiao.app_retrofit.utils;

import android.util.Log;

import com.djxiao.app_retrofit.network.CommuConst;

/**
 * @author djxiao
 * @create 2016/7/7 17:15
 * @DESC
 */
public class LogUtil {

    public final static String TAG = "Tag";

    public static void i(String msg){
        if (CommuConst.DEBUG){
            Log.i(TAG,msg);
        }
    }
    public static void d(String msg){
        if (CommuConst.DEBUG) {
            Log.d(TAG, msg);
        }
    }
    public static void v(String msg){
        if (CommuConst.DEBUG) {
            Log.v(TAG, msg);
        }
    }
    public static void e(String msg){
        if (CommuConst.DEBUG) {
            Log.e(TAG, msg);
        }
    }
    public static void w(String msg){
        if (CommuConst.DEBUG) {
            Log.w(TAG, msg);
        }
    }

}
