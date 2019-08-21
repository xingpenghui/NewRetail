package com.feri.shop.newretail.goods.dao;


import com.feri.shop.newretail.dto.GoodsLookDto;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Feri
 * @since 2019-08-21
 */
public interface GoodsDao{
    List<GoodsLookDto> selectLookTop();
}
