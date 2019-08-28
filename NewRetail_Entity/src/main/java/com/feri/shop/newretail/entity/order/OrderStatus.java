package com.feri.shop.newretail.entity.order;

import lombok.Data;

import java.math.BigInteger;
import java.util.Date;

/**
 * @program: NewRetail
 * @description:
 * @author: Feri
 * @create: 2019-08-28 11:22
 */
@Data
public class OrderStatus {
    private BigInteger id;
    private String oid;
    private int flag;//标记位
    private Date ctime ;//创建时间
    private Date modtime;//修改时间
}
