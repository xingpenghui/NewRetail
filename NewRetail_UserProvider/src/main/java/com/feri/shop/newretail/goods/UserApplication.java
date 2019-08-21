package com.feri.shop.newretail.goods;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @program: NewRetail
 * @description:
 * @author: Feri
 * @create: 2019-08-12 15:10
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.feri.shop.newretail.provider.dao")
@EnableTransactionManagement
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class,args);
    }
}
