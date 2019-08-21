package com.feri.shop.newretail.goods.config;

import com.feri.shop.newretail.common.util.JedisUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: NewRetail
 * @description:
 * @author: Feri
 * @create: 2019-08-21 14:56
 */
@Configuration
public class JedisConfig {
    @Bean
    public JedisUtil createJu(){
        return JedisUtil.getInstance();
    }
}