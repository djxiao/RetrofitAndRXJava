package com.djxiao.app_retrofit.network;

import com.djxiao.app_retrofit.response.BaseResponse;
import com.djxiao.app_retrofit.response.AddressByIpResponse;

/**
 * @author djxiao
 * @create 2016/7/7 17:35
 * @DESC  这里是解析报文
 */
public class ResponseFactory {

    public static BaseResponse parseAddressByIp(String content) {
        AddressByIpResponse response = new AddressByIpResponse();
        response.paser(content);
        return response;
    }
}
