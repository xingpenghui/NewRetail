package com.feri.shop.newretail.entity.goods;




import lombok.Data;

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
public class GoodsType {
    private Integer id;

    private String name;

    private Integer parentid;

    private Integer level;

    private Integer gsort;
}