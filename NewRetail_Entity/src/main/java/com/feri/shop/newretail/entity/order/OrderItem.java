package com.feri.shop.newretail.entity.order;

import lombok.Data;

import java.math.BigInteger;

/**
 * @program: NewRetail
 * @description:
 * @author: Feri
 * @create: 2019-08-28 11:22
 */
@Data
public class OrderItem {
    private BigInteger id;
    private String oid;
    private int gskuid;
    private int price;
    private int num;
}