package com.feri.shop.newretail.common.config;

/**
 * @program: NewRetail
 * @description:
 * @author: Feri
 * @create: 2019-08-12 16:23
 */
public class RedisKeyConfig {
    //短信限制
    public static final String SMSKEYM1="sms:first:m:";//后面追加手机号  值为次数  有效期1分钟
    public static final String SMSKEYM10="sms:ten:m:";//后面追加手机号  值为次数   有效期10分钟
    public static final String SMSKEYH1="sms:first:h:";//后面追加手机号  值为次数  有效期1小时
    public static final String SMSKEYD1="sms:first:d:";//后面追加手机号  值为次数  有效期1天

    //短信验证码
    public static final String SMSCODE="sms:code:";//后面追加手机号  值为验证码  有效期10分钟








}
