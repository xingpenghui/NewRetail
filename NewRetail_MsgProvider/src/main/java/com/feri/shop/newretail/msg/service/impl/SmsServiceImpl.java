package com.feri.shop.newretail.msg.service.impl;

import com.feri.shop.newretail.common.config.RedisKeyConfig;
import com.feri.shop.newretail.common.config.SmsConfig;
import com.feri.shop.newretail.common.util.JedisUtil;
import com.feri.shop.newretail.common.util.Random_Util;
import com.feri.shop.newretail.common.util.StrUtil;
import com.feri.shop.newretail.common.util.TimeUtil;
import com.feri.shop.newretail.common.vo.R;
import com.feri.shop.newretail.msg.service.SmsService;
import com.feri.shop.newretail.msg.util.SmsUtil;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @program: NewRetail
 * @description:
 * @author: Feri
 * @create: 2019-08-12 16:14
 */
@Service
public class SmsServiceImpl implements SmsService {
    private JedisUtil jedisUtil=JedisUtil.getInstance();
    @Override
    public R sendValidateCode(String phone) {
        //1天只能发20次
        if(jedisUtil.exists(RedisKeyConfig.SMSKEYD1+ SmsConfig.APITEMID+":"+phone)){
            int dc=Integer.parseInt(jedisUtil.get(RedisKeyConfig.SMSKEYD1+ SmsConfig.APITEMID+":"+phone));
            if(dc>=20){
                return R.setERROR("今日已达上限");
            }
        }
        //1小时只能发4次
        if(jedisUtil.exists(RedisKeyConfig.SMSKEYH1+ SmsConfig.APITEMID+":"+phone)){
            int hc=Integer.parseInt(jedisUtil.get(RedisKeyConfig.SMSKEYH1+ SmsConfig.APITEMID+":"+phone));
            if(hc>=4){
                return R.setERROR("请稍后再来");
            }
        }
        //10分钟只能发3次
        if(jedisUtil.exists(RedisKeyConfig.SMSKEYM10+ SmsConfig.APITEMID+":"+phone)){
            int mc=Integer.parseInt(jedisUtil.get(RedisKeyConfig.SMSKEYM10+ SmsConfig.APITEMID+":"+phone));
            if(mc>=3){
                return R.setERROR("请稍后再来");
            }
        }
        //1分钟只能发1次
        if(jedisUtil.exists(RedisKeyConfig.SMSKEYM1+ SmsConfig.APITEMID+":"+phone)){
            int mc1=Integer.parseInt(jedisUtil.get(RedisKeyConfig.SMSKEYM1+ SmsConfig.APITEMID+":"+phone));
            if(mc1>=1){
                return R.setERROR("请稍后再来");
            }
        }
        int code;
        //验证验证码是否有效
        if(jedisUtil.exists(RedisKeyConfig.SMSCODE+phone)){
            code= Integer.parseInt(jedisUtil.get(RedisKeyConfig.SMSCODE+phone));
        }else {
            code= Random_Util.createNum(6);
            jedisUtil.setExpire(RedisKeyConfig.SMSCODE+phone,code+"",600);
        }
        //验证码存储到Redis   有效期 10分钟
        boolean issuccess= SmsUtil.sendMsg(phone,code);
        //更新各种Key
        //1天
        setKey(RedisKeyConfig.SMSKEYD1+ SmsConfig.APITEMID+":"+phone,TimeUtil.getLastSeconds());
        //1小时
        setKey(RedisKeyConfig.SMSKEYH1+ SmsConfig.APITEMID+":"+phone,3600);
        //10分钟
        setKey(RedisKeyConfig.SMSKEYM10+ SmsConfig.APITEMID+":"+phone,600);
        //1分钟
        setKey(RedisKeyConfig.SMSKEYM1+ SmsConfig.APITEMID+":"+phone,60);
        return R.setResult(issuccess,"OK");
    }

    @Override
    public R checkCode(String phone, String code) {
        String cd=jedisUtil.get(RedisKeyConfig.SMSCODE+phone);
        if(StrUtil.checkNotEmpty(cd)){
            if(Objects.equals(code,cd)){
                jedisUtil.del(RedisKeyConfig.SMSCODE+phone);
                return R.setOK("校验验证码成功");
            }else {
                return R.setERROR("验证码不一致");
            }
        }else {
            return R.setERROR("验证码无效");
        }
    }
    private void setKey(String key,int seconds){
        if(jedisUtil.exists(key)){
            jedisUtil.setExpire(key,(Integer.parseInt(jedisUtil.get(key))+1)+"", (int)jedisUtil.ttl(key));
        }else {
            jedisUtil.setExpire(key,1+"",seconds);
        }
    }
}
