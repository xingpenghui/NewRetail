package com.feri.shop.newretail.order.service;

import com.feri.shop.newretail.common.vo.R;
import com.feri.shop.newretail.dto.CartItemDto;

public interface CartService {

    //添加购物车
    R saveCartItem(String token, CartItemDto itemDto);
    //查询用户的购物车列表
    R queryUserCart(String token);
    //更改购物车商品数量
    R changeNum(String token,int id,int num);
    //删除购物车中商品
    R delCartItem(String token,int id);

    //加入购物车 新增或修改
    R addCart(String token,CartItemDto itemDto);


}
