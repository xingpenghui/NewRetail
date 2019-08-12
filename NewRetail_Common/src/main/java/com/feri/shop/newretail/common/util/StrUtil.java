package com.feri.shop.newretail.common.util;

/**
 * @program: NewRetail
 * @description:
 * @author: Feri
 * @create: 2019-08-12 15:34
 */
public class StrUtil {

    public static boolean checkNotEmpty(String msg){
        return msg!=null && msg.length()>0;
    }

    public static boolean checkNotEmpty(String... msgs){
        for(String m:msgs){
            if(m==null || m.length()==0){
                return false;
            }
        }
        return true;

    }

}
