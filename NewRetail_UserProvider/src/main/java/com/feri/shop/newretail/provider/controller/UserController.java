package com.feri.shop.newretail.provider.controller;

import com.feri.shop.newretail.common.vo.R;
import com.feri.shop.newretail.dto.UserDto;
import com.feri.shop.newretail.provider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: NewRetail
 * @description:
 * @author: Feri
 * @create: 2019-08-12 15:40
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("nr/provider/user/save.do")
    public R save(@RequestBody UserDto userDto){
        return userService.save(userDto);
    }
    @GetMapping("nr/provider/user/detail.do")
    public R detail(@RequestParam("phone")String phone){
        return userService.queryPhone(phone);
    }
}
