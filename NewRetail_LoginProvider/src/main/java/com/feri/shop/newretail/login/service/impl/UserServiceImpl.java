package com.feri.shop.newretail.login.service.impl;

import com.alibaba.fastjson.JSON;
import com.feri.shop.newretail.common.config.KeyConfig;
import com.feri.shop.newretail.common.config.RedisKeyConfig;
import com.feri.shop.newretail.common.config.SystemConfig;
import com.feri.shop.newretail.common.jwt.JwtUtil;
import com.feri.shop.newretail.common.util.EncryptionUtil;
import com.feri.shop.newretail.common.util.JedisUtil;
import com.feri.shop.newretail.common.util.TimeUtil;
import com.feri.shop.newretail.common.vo.R;
import com.feri.shop.newretail.dto.LoginDto;
import com.feri.shop.newretail.dto.UserDto;
import com.feri.shop.newretail.entity.user.User;
import com.feri.shop.newretail.login.dao.UserDao;
import com.feri.shop.newretail.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Objects;
import java.util.Set;

/**
 * @program: NewRetail
 * @description:
 * @author: Feri
 * @create: 2019-08-14 14:14
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    private JedisUtil jedisUtil=JedisUtil.getInstance();

    @Override
    public R login(LoginDto loginDto) {
        //验证账号是否冻结
        if(jedisUtil.exists(RedisKeyConfig.LOGINFREEZE+loginDto.getPhone())){
            //账号冻结
            return R.setERROR("账号已被冻结，请明天再来");
        }else {
            //校验手机号是否存在
            User user=userDao.selectByPhone(loginDto.getPhone());
            loginDto.setId(user.getId());
            System.out.println("登录信息："+loginDto);
            if(user!=null){
                //校验密码
                if(Objects.equals(user.getPassword(), EncryptionUtil.AESEnc(KeyConfig.PASSKEY,loginDto.getPass()))){
                    //密码正确 生成令牌
                    String token= JwtUtil.createJWT(JSON.toJSONString(loginDto));
                    //验证当前设备类型下有没有登录过
                    if(jedisUtil.exists(RedisKeyConfig.USERTOKEN+loginDto.getPhone()+":"+loginDto.getType())){
                        //删除以前的数据
                        String t=jedisUtil.get(RedisKeyConfig.USERTOKEN+loginDto.getPhone()+":"+loginDto.getType());
                        //记录被迫下线
                        jedisUtil.hset(RedisKeyConfig.LOGINFORCE,t,loginDto.getMac());
                        //删除无用的Key
                        jedisUtil.del(RedisKeyConfig.JWTTOKEN+t,RedisKeyConfig.USERTOKEN+loginDto.getPhone()+":"+loginDto.getType());

                    }
                    //将令牌存储到Redis
                    jedisUtil.setExpire(RedisKeyConfig.JWTTOKEN+token,JSON.toJSONString(loginDto), SystemConfig.TOKENTIMES*60);
                    jedisUtil.setExpire(RedisKeyConfig.USERTOKEN+loginDto.getPhone()+":"+loginDto.getType(),token,SystemConfig.TOKENTIMES*60);
                    return R.setOK("OK",token);
                }
            }
            //失败次数记录  超过次数 冻结账号
            Set<String> errorKeys=jedisUtil.keys(RedisKeyConfig.LOGINERROR+loginDto.getPhone()+":*");
            if(errorKeys!=null){
                jedisUtil.setExpire(RedisKeyConfig.LOGINERROR+loginDto.getPhone()+":"+(errorKeys.size()+1),"",300);
                //失败过
                if(errorKeys.size()>=2){
                    jedisUtil.setExpire(RedisKeyConfig.LOGINFREEZE+loginDto.getPhone(), TimeUtil.getDate(),24*60*60);
                    return R.setERROR("连续失败多次，账号被冻结，请24小时之后再来");
                }
            }else {
                jedisUtil.setExpire(RedisKeyConfig.LOGINERROR+loginDto.getPhone()+":1","",300);
            }
        }
        return R.setERROR("用户名或密码错误，登录失败");
    }

    @Override
    public R checkToken(String token) {
        //1、校验JWT
        if(JwtUtil.checkJWT(token)){
            //2、校验令牌是否有效
            if(jedisUtil.exists(RedisKeyConfig.JWTTOKEN+token)){
                //令牌有效
                return R.setOK("令牌有效");
            }else {
                //校验是否被迫下线
                if(jedisUtil.hexists(RedisKeyConfig.LOGINFORCE,token)){
                    R r=R.setERROR("令牌无效，被迫下线",jedisUtil.hget(RedisKeyConfig.LOGINFORCE,token));
                    jedisUtil.hdel(RedisKeyConfig.LOGINFORCE,token);
                    return r;
                }
            }
        }
        return R.setERROR("令牌失效，请重新登录");
    }

    @Override
    public R findPass(UserDto userDto) {
        //1、验证账号是否被冻结
        if(!jedisUtil.exists(RedisKeyConfig.LOGINFREEZE+userDto.getPhone())) {
            //2、修改密码
           int r= userDao.updatePass(userDto.getPhone(),EncryptionUtil.AESEnc(KeyConfig.PASSKEY,userDto.getPass()));
           if(r>0){
              delKeys(userDto.getPhone());
           }
           return R.setResult(r>0,"密码找回");
        }else {
            return R.setERROR("账号被冻结，暂无法操作");
        }
    }

    @Override
    public R changePass(String token, String pass) {
        //1、校验令牌是否有效
        if(jedisUtil.exists(RedisKeyConfig.JWTTOKEN+token)){
            //2、取出用户数据
            LoginDto loginDto=JSON.parseObject(jedisUtil.get(RedisKeyConfig.JWTTOKEN+token),LoginDto.class);
            int r=userDao.updatePass(loginDto.getPhone(),EncryptionUtil.AESEnc(KeyConfig.PASSKEY,pass));
            if(r>0){
                delKeys(loginDto.getPhone());
            }
            return R.setResult(r>0,"密码修改");
        }else {
            return R.setERROR("令牌无效，重新登录");
        }
    }

    @Override
    public R exit(String token) {
        if(jedisUtil.exists(RedisKeyConfig.JWTTOKEN+token)){
            //各种删除
            LoginDto loginDto=JSON.parseObject(jedisUtil.get(RedisKeyConfig.JWTTOKEN+token),LoginDto.class);
            delKeys(loginDto.getPhone());
            return R.setOK("注销成功");
        }else {
            return R.setERROR("令牌无效，重新登录");
        }
    }

    @Override
    public R checkFreeze(String phone) {
        return R.setResult(!jedisUtil.exists(RedisKeyConfig.LOGINFREEZE+phone),"账号可用");
    }

    private void delKeys(String phone){
            //密码修改成功 当前的所有相关的信息全部失效
            Set<String> sets=jedisUtil.keys(RedisKeyConfig.USERTOKEN+phone+":*");
            for(String s:sets){
                String t=jedisUtil.get(RedisKeyConfig.JWTTOKEN+jedisUtil.get(s));
                //删除
                jedisUtil.del(s,RedisKeyConfig.JWTTOKEN+t);
                jedisUtil.hdel(RedisKeyConfig.LOGINFORCE,t);
            }

    }
}
