package com.feri.shop.newretail.goods.service;

import com.feri.shop.newretail.common.vo.R;

/**
 * <p>
 * </p>
 * @author Feri
 * @since 2019-08-21
 */
public interface GoodsService {
    R queryLookTop();
    R changeRepertory(int gskuid,int num);
}
