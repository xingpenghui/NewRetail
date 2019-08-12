package com.feri.shop.newretail.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 *@program: NewRetail
 *@description: 注册中心 开关类
 *@author: Feri
 *@create: 2019-08-12 11:38
 */
@SpringBootApplication
@EnableEurekaServer //基于Eureka实现注册中心
public class RegistryApplication {
    public static void main(String[] args) {
        SpringApplication.run(RegistryApplication.class,args);
    }
}
