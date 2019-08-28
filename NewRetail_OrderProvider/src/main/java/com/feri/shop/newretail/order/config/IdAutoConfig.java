package com.feri.shop.newretail.order.config;

import com.feri.shop.newretail.common.util.IdGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: NewRetail
 * @description:
 * @author: Feri
 * @create: 2019-08-28 12:07
 */
@Configuration
public class IdAutoConfig {
    @Bean
    public IdGenerator creatrId(){
        return new IdGenerator();
    }
}
