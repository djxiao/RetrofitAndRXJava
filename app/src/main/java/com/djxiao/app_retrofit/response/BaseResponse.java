package com.djxiao.app_retrofit.response;

import android.util.Log;

import com.djxiao.app_retrofit.network.CommuConst;
import com.djxiao.app_retrofit.utils.LogUtil;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Comment;

/**
 * @author djxiao
 * @create 2016/7/7 15:01
 * @DESC
 */
public abstract class BaseResponse {

    private int statueCode = -1;
    private String msg = "";
    private String data = "";

    public void paser(String content){
        Log.i("Tag",content);
        try {
            JSONObject json = new JSONObject(content);
            statueCode = json.optInt("code",-1);
            if(statueCode == CommuConst.RESULT_OK){
                data = json.optString("data",null);
                if(data != null){
                    JSONObject obj = new JSONObject(data);
                    parseBody(obj);
                }

            }else{
                msg = json.optString("data",null);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public abstract void parseBody(JSONObject json);


    public void setStatueCode(int statueCode) {
        this.statueCode = statueCode;
    }

    public int getStatueCode() {
        return statueCode;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
