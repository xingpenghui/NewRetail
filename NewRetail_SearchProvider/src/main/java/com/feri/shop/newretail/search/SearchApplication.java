package com.feri.shop.newretail.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @program: NewRetail
 * @description:
 * @author: Feri
 * @create: 2019-08-21 15:57
 */
@SpringBootApplication
@EnableScheduling
public class SearchApplication {
    public static void main(String[] args) {
        SpringApplication.run(SearchApplication.class,args);
    }
}
