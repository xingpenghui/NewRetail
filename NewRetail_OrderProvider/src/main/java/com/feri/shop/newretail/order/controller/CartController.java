package com.feri.shop.newretail.order.controller;

import com.feri.shop.newretail.common.config.SystemConfig;
import com.feri.shop.newretail.common.vo.R;
import com.feri.shop.newretail.dto.CartItemDto;
import com.feri.shop.newretail.order.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

/**
 * @program: NewRetail
 * @description:
 * @author: Feri
 * @create: 2019-08-27 16:11
 */
@RestController
public class CartController {
    @Autowired
    private CartService cartService;

    //添加购物车
    @PostMapping("/provider/cart/addcart.do")
    public R save(@RequestBody CartItemDto itemDto, HttpServletRequest request){
        return cartService.addCart(request.getHeader(SystemConfig.HEARDTOKEN),itemDto);
    }
}