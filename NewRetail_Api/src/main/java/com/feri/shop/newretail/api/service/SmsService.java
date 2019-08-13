package com.feri.shop.newretail.api.service;

import com.feri.shop.newretail.common.vo.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @program: NewRetail
 * @description:
 * @author: Feri
 * @create: 2019-08-13 09:46
 */
@FeignClient("MsgProvider")
public interface SmsService {
    @GetMapping("nr/provider/sms/sendvc.do")
     R sendSms(@RequestParam("phone") String phone);
    @GetMapping("nr/provider/sms/checkvc.do")
    R checkVC(@RequestParam("phone") String phone, @RequestParam("code")String code);
}