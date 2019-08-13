package com.feri.shop.newretail.api.service;

import com.feri.shop.newretail.common.vo.R;
import com.feri.shop.newretail.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @program: NewRetail
 * @description:
 * @author: Feri
 * @create: 2019-08-12 17:40
 */
@FeignClient("UserProvider")
public interface UserService {
    @PostMapping("nr/provider/user/save.do")
    R save(@RequestBody UserDto userDto);
    @GetMapping("nr/provider/user/detail.do")
    R check(@RequestParam("phone")String phone);
}