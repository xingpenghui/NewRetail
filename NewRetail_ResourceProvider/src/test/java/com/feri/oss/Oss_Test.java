package com.feri.oss;

import com.feri.shop.newretail.resource.core.util.OssUtil;
import org.junit.Test;

/**
 * @program: NewRetail
 * @description:
 * @author: Feri
 * @create: 2019-08-15 14:54
 */
public class Oss_Test {
    @Test
    public void t1(){
       // OssUtil.createBucket("zz1test1903");
        String u=OssUtil.sendFile("zz1test1903","obj2","Hello Java");
        System.out.println(u);
    }
}
