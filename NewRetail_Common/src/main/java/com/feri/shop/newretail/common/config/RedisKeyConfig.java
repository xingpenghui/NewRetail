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


    //令牌 JWT
    public static final String JWTTOKEN="jwttoken:";//后面追加令牌 key为令牌 值为用户信息  30分钟
    public static final String USERTOKEN="usertoken:";//后面追加手机号:设备类型 key为手机号和类型 值为当前设备的令牌 30分钟

    //失败拦截
    public static final String LOGINERROR="login:error:";//后面手机号 key为手机号:失败的次数  值为空 5分钟 3次
    public static final String LOGINFREEZE="user:freeze:";//后面追加手机号 key为手机号 值为初始时间 24小时

    //被迫下线 手机号 设备
    public static final String LOGINFORCE="login:froce";// Hash类型 字段：令牌 值：设备号 没有有效期


    //排行榜的Key
    public static final String TOPLOOK="goods:top:look";//记录商品的浏览排行榜

    //Redis命令 2.8版本之后 新增的scan 可以实现非阻塞式查询  代替Keys


    //Es搜索中心涉及到Key
    public static final String ESGOODSADD="es:goods:add";//记录商品的间隔时间内的新增
    public static final String ESGOODSUPDATE="es:goods:update";//记录商品的间隔时间内的修改
    public static final String ESGOODSDEL="es:goods:del";//记录商品的间隔时间内的删除








}
