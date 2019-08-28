package com.feri.shop.newretail.entity.order;

import lombok.Data;

import java.math.BigInteger;

/**
 * @program: NewRetail
 * @description:
 * @author: Feri
 * @create: 2019-08-28 14:09
 */
@Data
public class OrderAddress {
    private BigInteger id;
    private String oid;
    private String address;
    private String detail;
    private String name;
    private String phone;

}
