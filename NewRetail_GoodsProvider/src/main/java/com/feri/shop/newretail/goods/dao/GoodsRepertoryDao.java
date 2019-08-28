package com.feri.shop.newretail.goods.dao;


import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Feri
 * @since 2019-08-21
 */
public interface GoodsRepertoryDao {
    @Update("update t_goods_repertory set count=count-#{num} where gskuid=#{gskuid} and count>=#{num}")
    int update(@Param("gskuid") int gskuid, @Param("num") int num);


}
