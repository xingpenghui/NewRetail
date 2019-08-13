package com.feri.shop.newretail.msg.config;

import com.rabbitmq.client.AMQP;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: NewRetail
 * @description:
 * @author: Feri
 * @create: 2019-08-13 14:47
 */
@Configuration
public class RabbitMQConfig {
    //定义队列
    public static String qname="nrsmsvc";
    //定义交换器
    public static String ename="smsvc";

    //创建队列对象
    @Bean
    public Queue createQueue(){
        return new Queue(qname);
    }
    //创建交换器对象
    @Bean
    public Exchange createExchange(){
        return ExchangeBuilder.fanoutExchange(ename).build();
    }
    @Bean
    public Binding createBind(Queue queue,Exchange exchange){
       return BindingBuilder.bind(queue).to(exchange).with("").noargs();
    }


}
