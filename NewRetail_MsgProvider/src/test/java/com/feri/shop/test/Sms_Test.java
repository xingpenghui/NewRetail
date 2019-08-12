package com.feri.shop.test;

import com.feri.shop.newretail.common.util.Random_Util;
import com.feri.shop.newretail.msg.util.SmsUtil;
import org.junit.Test;

/**
 * @program: NewRetail
 * @description:
 * @author: Feri
 * @create: 2019-08-12 16:08
 */
public class Sms_Test {
    @Test
    public void test1(){
        System.out.println(SmsUtil.sendMsg("15638837798", Random_Util.createNum(6)));
    }
}
