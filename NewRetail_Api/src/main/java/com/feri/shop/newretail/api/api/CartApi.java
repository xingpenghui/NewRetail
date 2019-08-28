package com.feri.shop.newretail.api.api;

import com.feri.shop.newretail.api.service.CartService;
import com.feri.shop.newretail.common.vo.R;
import com.feri.shop.newretail.dto.CartItemDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: NewRetail
 * @description:
 * @author: Feri
 * @create: 2019-08-27 17:22
 */
@Api(value = "购物车相关操作",tags = "购物车相关操作")
@RestController
public class CartApi {
    @Autowired
    private CartService cartService;

    @PostMapping("/api/cart/addcart.do")
    @ApiOperation(value = "添加购物车",notes = "添加购物车")
    public R save(@RequestBody CartItemDto itemDto, HttpServletRequest request) {
        return cartService.save(itemDto);
    }
}
