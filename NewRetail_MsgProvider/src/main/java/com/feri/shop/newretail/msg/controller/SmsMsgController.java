package com.feri.shop.newretail.msg.controller;

import com.feri.shop.newretail.common.vo.R;
import com.feri.shop.newretail.msg.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: NewRetail
 * @description:
 * @author: Feri
 * @create: 2019-08-12 17:22
 */
@RestController
public class SmsMsgController {
    @Autowired
    private SmsService smsService;

    @GetMapping("nr/provider/sms/sendvc.do")
    public R sendSms(@RequestParam("phone") String phone){
        return smsService.sendValidateCode(phone);
    }
    @GetMapping("nr/provider/sms/checkvc.do")
    public R checkVC(@RequestParam("phone") String phone,@RequestParam("code") String code){
        return smsService.checkCode(phone, code);
    }
}
