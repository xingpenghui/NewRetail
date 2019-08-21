package com.feri.shop.newretail.goods.service.impl;

import com.feri.shop.newretail.common.config.KeyConfig;
import com.feri.shop.newretail.common.util.EncryptionUtil;
import com.feri.shop.newretail.common.util.StrUtil;
import com.feri.shop.newretail.common.vo.R;
import com.feri.shop.newretail.dto.UserDto;
import com.feri.shop.newretail.entity.user.User;
import com.feri.shop.newretail.goods.dao.UserDao;
import com.feri.shop.newretail.goods.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: NewRetail
 * @description:
 * @author: Feri
 * @create: 2019-08-12 15:30
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public R queryPhone(String phone) {
        if(StrUtil.checkNotEmpty(phone)){
            User user=userDao.selectByPhone(phone);
            if(user!=null){
                return R.setERROR("手机号不可用");
            }else {
                return R.setOK("手机号可用");
            }
        }
        else {
            return R.setERROR("请传递手机号");
        }
    }

    @Override
    public R save(UserDto userDto) {
        User user=new User();
        user.setPassword(EncryptionUtil.AESEnc(KeyConfig.PASSKEY,userDto.getPass()));
        user.setPhone(userDto.getPhone());
        int r=userDao.save(user);
        return R.setResult(r>0,"新增用户");
    }
}
