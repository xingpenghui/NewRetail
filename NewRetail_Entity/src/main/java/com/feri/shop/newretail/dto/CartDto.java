package com.feri.shop.newretail.dto;

import lombok.Data;

/**
 * @program: NewRetail
 * @description:
 * @author: Feri
 * @create: 2019-08-27 15:09
 */
@Data
public class CartDto {
    private int cid;
    private String gname;
    private String gimgurl;
    private int gprice;
    private int num;
    private String skujson;

}
