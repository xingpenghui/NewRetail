package com.feri.shop.newretail.api.api;

import com.feri.shop.newretail.api.service.SmsService;
import com.feri.shop.newretail.common.vo.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: NewRetail
 * @description:
 * @author: Feri
 * @create: 2019-08-13 15:09
 */
@Api(value = "",tags = "短信操作")
@RestController
public class SmsApi {
    @Autowired
    private SmsService smsService;
    @ApiOperation(value = "",notes = "发送短信验证码")
    @GetMapping("/api/sms/sendvc/{phone}")
    public R sendVc(@PathVariable String phone){
        return smsService.sendSms(phone);
    }
    @ApiOperation(value = "",notes = "验证短信验证码")
    @GetMapping("/api/sms/checkvc/{phone}/{code}")
    public R sendVc(@PathVariable String phone,@PathVariable String code){
        return smsService.checkVC(phone,code);
    }



}
