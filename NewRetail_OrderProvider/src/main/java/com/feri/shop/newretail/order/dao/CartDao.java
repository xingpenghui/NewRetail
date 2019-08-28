package com.feri.shop.newretail.order.dao;

import com.feri.shop.newretail.dto.CartDto;
import com.feri.shop.newretail.entity.cart.Cart;

import java.util.List;

public interface CartDao {
    int insert(Cart cart);
    List<CartDto> selectByUid(int uid);
    int selectCid(int uid);
}
