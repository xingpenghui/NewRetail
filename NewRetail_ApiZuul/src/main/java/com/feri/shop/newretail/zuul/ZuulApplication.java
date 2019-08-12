package com.feri.shop.newretail.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @program: NewRetail
 * @description:
 * @author: Feri
 * @create: 2019-08-12 11:43
 */
@SpringBootApplication
@EnableDiscoveryClient //注册和发现服务
@EnableZuulProxy  //启用Zuul
public class ZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class,args);
    }
}
