package com.feri.shop.newretail.entity.goods;


import lombok.Data;
import java.util.Date;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Feri
 * @since 2019-08-21
 */
@Data
public class GoodsMedia {
    private Integer id;
    private Integer gid;
    private String mediaurl;
    private Integer type;
    private String info;
    private Integer msort;
    private Date ctime;
    private Integer cskuid;
}