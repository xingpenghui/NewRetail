package com.feri.shop.newretail.entity.order;

import lombok.Data;

import java.util.Date;

/**
 * @program: NewRetail
 * @description:
 * @author: Feri
 * @create: 2019-08-28 11:22
 */
@Data
public class Order {
    private String id;
    private int uid;
    private int orderPrice; //订单价格
    private int price;//实际价格 支付价格
    private int discountPrice; //优惠价格
    private Date ctime;
    private String source;//订单来源

}
