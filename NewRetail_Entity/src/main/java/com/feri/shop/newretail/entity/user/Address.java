package com.feri.shop.newretail.entity.user;

import lombok.Data;

/**
 * @program: NewRetail
 * @description:
 * @author: Feri
 * @create: 2019-08-28 11:23
 */
@Data
public class Address {
    private int id;
    private String province;
    private String city;
    private String country;
    private String street;//街道
    private String detail;
    private String recName;//收货人
    private String phone;//包含座机
    private int flag;//标记位 1 默认地址 2为常规地址
    private int asort;//排序
    private int uid;



}
