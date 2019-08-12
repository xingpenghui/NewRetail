package com.feri.shop.newretail.msg.util;

import com.alibaba.fastjson.JSON;
import com.feri.shop.newretail.common.config.SmsConfig;
import com.feri.shop.newretail.common.util.Http_Util;
import com.feri.shop.newretail.common.util.Random_Util;
import com.feri.shop.newretail.msg.model.SmsResult;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @program: NewRetail
 * @description: 短信工具类 聚合数据
 * @author: Feri
 * @create: 2019-08-12 15:59
 */
public class SmsUtil {
    public static boolean sendMsg(String phone,int code){
        String url= null;
        try {
            url = "http://v.juhe.cn/sms/send?tpl_id="+ SmsConfig.APITEMID +"&key="+SmsConfig.APIKEY+"&mobile="+phone+"&tpl_value="+ URLEncoder.encode("#code#="+code,"UTF-8");
            String json=Http_Util.getStr(url);
            SmsResult sr= JSON.parseObject(json,SmsResult.class);
            return sr.getError_code()==0;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return false;

    }

}
