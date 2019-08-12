package com.feri.shop.newretail.msg.service;

import com.feri.shop.newretail.common.vo.R;

public interface SmsService {
    R sendValidateCode(String phone);
    R checkCode(String phone,String code);
}
