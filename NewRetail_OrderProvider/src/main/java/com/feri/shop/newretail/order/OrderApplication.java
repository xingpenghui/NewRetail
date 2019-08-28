package com.feri.shop.newretail.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @program: NewRetail
 * @description:
 * @author: Feri
 * @create: 2019-08-27 15:56
 */
@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.feri.shop.newretail.order.dao")
@EnableDiscoveryClient
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class,args);
    }
}
