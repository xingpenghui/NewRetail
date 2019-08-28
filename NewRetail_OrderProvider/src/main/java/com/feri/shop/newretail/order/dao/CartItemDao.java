package com.feri.shop.newretail.order.dao;

import com.feri.shop.newretail.entity.cart.CartItem;
import org.apache.ibatis.annotations.Param;

public interface CartItemDao {
    int insert(CartItem item);
    int updateNum(@Param("id") int id, @Param("n") int n);
    int delById(int id);
    CartItem selectGskuid(@Param("uid") int uid,@Param("") int gskuid);
}
