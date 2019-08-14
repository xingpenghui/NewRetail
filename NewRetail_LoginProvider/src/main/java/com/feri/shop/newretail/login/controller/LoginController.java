package com.feri.shop.newretail.login.controller;

import com.feri.shop.newretail.common.config.SystemConfig;
import com.feri.shop.newretail.common.vo.R;
import com.feri.shop.newretail.dto.LoginDto;
import com.feri.shop.newretail.dto.UserDto;
import com.feri.shop.newretail.login.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

/**
 * @program: NewRetail
 * @description:
 * @author: Feri
 * @create: 2019-08-14 16:00
 */
@RestController
public class LoginController {
    @Autowired
    private UserService userService;

    //校验是否被冻结
    @GetMapping("nr/login/checkfreeze/{phone}")
    public R checkP(@PathVariable String phone){
        return userService.checkFreeze(phone);
    }
    //校验是否有效
    @GetMapping("nr/login/checklogin")
    public R checkP(HttpServletRequest request){
        return userService.checkToken(request.getHeader(SystemConfig.HEARDTOKEN));
    }
    //登录
    @HystrixCommand(fallbackMethod = "loginError")
    @PostMapping("nr/login/login")
    public R login(@RequestBody LoginDto loginDto){
        return userService.login(loginDto);
    }
    //密码找回
    @PostMapping("nr/login/findpass")
    public R login(@RequestBody UserDto userDto){
        return userService.findPass(userDto);
    }
    //修改密码
    @PostMapping("nr/login/resetpass/{pass}")
    public R checkP(HttpServletRequest request,@PathVariable String pass){
        return userService.changePass(request.getHeader(SystemConfig.HEARDTOKEN),pass);
    }
    //注销
    @GetMapping("nr/login/loginexit")
    public R exit(HttpServletRequest request){
        return userService.exit(request.getHeader(SystemConfig.HEARDTOKEN));
    }

    public R loginError(LoginDto loginDto){
        return R.setERROR("请检查你的网络");
    }


}
