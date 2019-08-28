package com.feri.shop.newretail.entity.cart;

import lombok.Data;

import java.util.Date;

/**
 * @program: NewRetail
 * @description:
 * @author: Feri
 * @create: 2019-08-27 15:53
 */
@Data
public class Cart {
    private int id;
    private int uid;
    private Date cdate;
}
