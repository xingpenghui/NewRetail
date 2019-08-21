package com.feri.shop.newretail.entity.goods;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * <p>
 * scan
 * </p>
 *
 * @author Feri
 * @since 2019-08-21
 */
@Data
public class Goods {
    private Integer id;
    private String name;
    private Integer tid;
    private Integer bid;
    private Date ctime;
    private Date modtime;
    private Integer flag;
    private String imgurl;
    /**
     * 标签 json数组格式
     */
    private String tags;
}