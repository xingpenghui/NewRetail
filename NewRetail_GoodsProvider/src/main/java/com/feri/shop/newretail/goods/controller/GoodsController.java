package com.feri.shop.newretail.goods.controller;

import com.feri.shop.newretail.common.vo.R;
import com.feri.shop.newretail.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: NewRetail
 * @description:
 * @author: Feri
 * @create: 2019-08-21 14:03
 */
@RestController
public class GoodsController {

    @Autowired
    private GoodsService goodsService;
    //查询浏览排行榜
    @GetMapping("/provider/goods/toplook.do")
    public R look(){
        return goodsService.queryLookTop();
    }
}
