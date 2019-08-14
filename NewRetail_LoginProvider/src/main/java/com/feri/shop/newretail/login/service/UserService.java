package com.feri.shop.newretail.login.service;

import com.feri.shop.newretail.common.vo.R;
import com.feri.shop.newretail.dto.LoginDto;
import com.feri.shop.newretail.dto.UserDto;

public interface UserService {
    //登录
    R login(LoginDto loginDto);
    //校验令牌
    R checkToken(String token);
    //找回密码
    R findPass(UserDto userDto);
    //修改密码
    R changePass(String token,String pass);
    //注销
    R exit(String token);
    //校验账号是否被冻结
    R checkFreeze(String phone);

}
