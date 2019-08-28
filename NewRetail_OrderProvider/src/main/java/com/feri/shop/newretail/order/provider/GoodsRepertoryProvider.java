package com.feri.shop.newretail.order.provider;

import com.feri.shop.newretail.common.vo.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("GoodsProvider")
public interface GoodsRepertoryProvider {
    @GetMapping("/provider/goods/changrepertory.do")
    R change(int gskuid, int num);
}
