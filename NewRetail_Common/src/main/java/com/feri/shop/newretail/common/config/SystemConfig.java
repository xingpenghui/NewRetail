package com.feri.shop.newretail.common.config;

/**
 * @program: NewRetail
 * @description:
 * @author: Feri
 * @create: 2019-08-14 10:53
 */
public class SystemConfig {
    //令牌的有效期
    public static int TOKENTIMES=30;
    //令牌的秘钥
    public static String TOKENKEY="nrjwtlogin";

    //令牌的消息头的key
    public static final String HEARDTOKEN="nrusertoken";

    //oss存储名称
    public static  final String OSSBUCKET="zzjavanewretail";

}
