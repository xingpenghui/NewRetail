package com.feri.shop.newretail.api.api;

import com.feri.shop.newretail.api.service.LoginService;
import com.feri.shop.newretail.common.vo.R;
import com.feri.shop.newretail.dto.LoginDto;
import com.feri.shop.newretail.dto.UserDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

/**
 * @program: NewRetail
 * @description:
 * @author: Feri
 * @create: 2019-08-14 16:13
 */
@Api(value = "",tags = "实现鉴权中心")
@RestController
public class LoginApi {
    @Autowired
    private LoginService loginService;

    //校验是否被冻结
    @GetMapping("api/login/checkfreeze/{phone}")
    @ApiOperation(value = "",notes = "校验是否被冻结")
    public R checkP(@PathVariable String phone){
        return loginService.checkP(phone);
    }
    //校验是否有效
    @GetMapping("api/login/checklogin")
    @ApiOperation(value = "",notes = "校验是否有效")
    public R checkP(HttpServletRequest request){
        return loginService.checkToken();
    }
    //登录
    @PostMapping("api/login/login")
    @ApiOperation(value = "",notes = "实现登录")
    public R login(@RequestBody LoginDto loginDto){
        return loginService.login(loginDto);
    }
    //密码找回
    @PostMapping("api/login/findpass")
    @ApiOperation(value = "",notes = "密码找回")
    public R login(@RequestBody UserDto userDto){
        return loginService.findPass(userDto);
    }
    //修改密码
    @PostMapping("api/login/resetpass/{pass}")
    @ApiOperation(value = "",notes = "修改密码")
    public R checkP(HttpServletRequest request,@PathVariable String pass){
        return loginService.changePass(pass);
    }
    //注销
    @GetMapping("api/login/loginexit")
    @ApiOperation(value = "",notes = "注销")
    public R exit(HttpServletRequest request){
        return loginService.exit();
    }
}
