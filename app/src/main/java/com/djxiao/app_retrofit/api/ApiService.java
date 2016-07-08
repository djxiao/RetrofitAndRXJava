package com.djxiao.app_retrofit.api;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * @author djxiao
 * @create 2016/7/4 15:12
 * @DESC  这里是请求地址和返回的bean
 */
public interface ApiService {

    @GET("http://ip.taobao.com/service/getIpInfo.php")
    Observable<String> getAddressByIp(@Query("ip") String ip);

}
