package com.feri.shop.newretail.api.config;

import com.feri.shop.newretail.common.config.SystemConfig;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;

/**
 * @program: NewRetail
 * @description:n 解决Feign无法传递 请求消息头的内容
 * @author: Feri
 * @create: 2019-08-15 10:00
 */
@Configuration
public class FeignConfig implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
         //获取请求消息头
        ServletRequestAttributes attributes= (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        //获取请求对象
        HttpServletRequest request=attributes.getRequest();
        //设置 消息头传递
        requestTemplate.header(SystemConfig.HEARDTOKEN,request.getHeader(SystemConfig.HEARDTOKEN));
    }
}
