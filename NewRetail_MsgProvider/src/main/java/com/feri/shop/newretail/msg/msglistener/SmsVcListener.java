package com.feri.shop.newretail.msg.msglistener;

import com.alibaba.fastjson.JSON;
import com.feri.shop.newretail.msg.model.VCode;
import com.feri.shop.newretail.msg.util.SmsUtil;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @program: NewRetail
 * @description:
 * @author: Feri
 * @create: 2019-08-13 15:00
 */
@Component
@RabbitListener(queues = "nrsmsvc") //设置监听的队列名称
public class SmsVcListener {
   @RabbitHandler //消息获取方法
    public void receive(String json){
        VCode vCode= JSON.parseObject(json,VCode.class);
        SmsUtil.sendMsg(vCode.getPhone(),vCode.getCode());
    }
}
