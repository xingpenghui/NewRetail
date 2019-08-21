package com.feri.shop.newretail.goods.service;


import com.feri.shop.newretail.common.vo.R;
import com.feri.shop.newretail.dto.UserDto;

public interface UserService {
    //查询手机号
    R queryPhone(String phone);
    //新增用户
    R save(UserDto userDto);

}
