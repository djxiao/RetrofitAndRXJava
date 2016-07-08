package com.djxiao.app_retrofit.response;

import android.util.Log;

import com.djxiao.app_retrofit.utils.LogUtil;

import org.json.JSONObject;

/**
 * @author djxiao
 * @create 2016/7/7 15:57
 * @DESC  通过IP获取地址
 */
public class AddressByIpResponse extends BaseResponse {

    public String country;
    public String country_id;
    public String area;
    public String area_id;
    public String region;
    public String region_id;
    public String city;
    public String city_id;
    public String county;
    public String county_id;
    public String isp;
    public String isp_id;
    public String ip;

    @Override
    public void parseBody(JSONObject json) {
        country = json.optString("country",null);
        country_id = json.optString("country_id",null);
        area = json.optString("area",null);
        area_id = json.optString("area_id",null);
        region = json.optString("region",null);
        region_id = json.optString("region_id",null);
        city = json.optString("city",null);
        city_id = json.optString("city_id",null);
        county = json.optString("county",null);
        county_id = json.optString("county_id",null);
        isp = json.optString("isp",null);
        isp_id = json.optString("isp_id",null);
        ip = json.optString("ip",null);
    }
}
