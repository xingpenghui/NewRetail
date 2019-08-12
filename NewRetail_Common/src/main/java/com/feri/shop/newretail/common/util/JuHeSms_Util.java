package com.feri.shop.newretail.common.util;


import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 *@Author feri
 *@Date Created in 2019/7/9 15:00
 * 基于聚合数据 实现短信验证码的发送
 */
public class JuHeSms_Util {
    public static final String SMS_URL="http://v.juhe.cn/sms/send";
    public static final int TPL_Id=164087;
    public static final String SMS_KEY="97245bbce1178f6b82233a8c631e4c76";

    public static boolean sendMsg(String phone,int code) throws UnsupportedEncodingException {
        StringBuffer buffer=new StringBuffer(SMS_URL);
        buffer.append("?mobile="+phone);
        buffer.append("&tpl_id="+TPL_Id);
        buffer.append("&tpl_value="+URLEncoder.encode("#code#="+code,"UTF-8"));
        buffer.append("&key="+SMS_KEY);
        String json=Http_Util.getStr(buffer.toString());
        if(json!=null) {
//            JuheSms sms = JSON.parseObject(json, JuheSms.class);
//            return sms.getError_code() == 0;
            return true;
        }else {
            return false;
        }
    }
}
