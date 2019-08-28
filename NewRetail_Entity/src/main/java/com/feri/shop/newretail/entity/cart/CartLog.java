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
public class CartLog {
    private int id;
    private int cid;
    private String msg;
    private Date ctime;

    public CartLog(int cid, String msg) {
        this.cid = cid;
        this.msg = msg;
    }

    public CartLog() {
    }
}
