package com.feri.shop.newretail.common.util;

import java.util.Random;

/**
 *@Author feri
 *@Date Created in 2019/7/9 15:16
 */
public class Random_Util {
    //根据传递位数 生成指定长度的随机数字
    public static int createNum(int len){
        Random random=new Random();
        //3  100-999  10 3幂 -1 0-899 900  1000-9999 1000 0-8999  9000
        int num=(int)Math.pow(10,len-1);
        return random.nextInt((int)(Math.pow(10,len)-num))+num;
    }
}
