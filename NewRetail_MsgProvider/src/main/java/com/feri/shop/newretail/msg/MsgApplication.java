package com.feri.shop.newretail.msg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: NewRetail
 * @description:
 * @author: Feri
 * @create: 2019-08-12 15:59
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MsgApplication {
    public static void main(String[] args) {
        SpringApplication.run(MsgApplication.class,args);
    }
}
