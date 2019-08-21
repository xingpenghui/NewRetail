package com.feri.shop.newretail.goods;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: NewRetail
 * @description:
 * @author: Feri
 * @create: 2019-08-21 12:53
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("")
public class GoodsApplication {
    public static void main(String[] args) {
        SpringApplication.run(GoodsApplication.class,args);
    }
}
