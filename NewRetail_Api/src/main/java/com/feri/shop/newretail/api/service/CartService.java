package com.feri.shop.newretail.api.service;

import com.feri.shop.newretail.common.vo.R;
import com.feri.shop.newretail.dto.CartItemDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;

@FeignClient("OrderProvider")
public interface CartService {
    @PostMapping("/provider/cart/addcart.do")
    R save(@RequestBody CartItemDto itemDto);
}
