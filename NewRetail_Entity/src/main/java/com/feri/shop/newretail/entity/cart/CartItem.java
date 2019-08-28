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
public class CartItem {
    private int id;
    private int cid;
    private int gskuid;
    private int num;
    private int cartprice;//加入购物车的价格  方便多对比
    private Date ctime;//加入的时间


}
