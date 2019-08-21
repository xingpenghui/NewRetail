package com.feri.shop.newretail.search.controller;

import com.feri.shop.newretail.common.vo.R;
import com.feri.shop.newretail.search.service.SearchGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: NewRetail
 * @description:
 * @author: Feri
 * @create: 2019-08-21 16:46
 */
@RestController
public class SearchController {
    @Autowired
    private SearchGoodsService goodsService;

    @GetMapping("provider/search/searchall.do")
    public R search(String key){
        return goodsService.queryKey(key);
    }

}
