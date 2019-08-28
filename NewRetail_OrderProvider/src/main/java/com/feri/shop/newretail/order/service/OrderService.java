package com.feri.shop.newretail.order.service;

import com.feri.shop.newretail.common.vo.R;
import com.feri.shop.newretail.dto.OrderNowDto;
import com.feri.shop.newretail.entity.cart.CartItem;

import java.util.List;

/**
 * @program: NewRetail
 * @description:
 * @author: Feri
 * @create: 2019-08-28 11:31
 */
public interface OrderService {
    //下单  立即购买
    R saveOrder(String token, OrderNowDto nowDto);
    //下单  购物车结算
    R saveOrder(List<CartItem> itemList);
    //查询超时订单
    R queryOrderTime();
    //取消订单
    R cancelOrder(String oid);


}
