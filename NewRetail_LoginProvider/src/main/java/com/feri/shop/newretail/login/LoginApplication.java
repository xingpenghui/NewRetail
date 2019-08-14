package com.feri.shop.newretail.login;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @program: NewRetail
 * @description:
 * @author: Feri
 * @create: 2019-08-14 13:12
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.feri.shop.newretail.login.dao")
@EnableHystrix
public class LoginApplication {
    public static void main(String[] args) {
        SpringApplication.run(LoginApplication.class,args);
    }
}
