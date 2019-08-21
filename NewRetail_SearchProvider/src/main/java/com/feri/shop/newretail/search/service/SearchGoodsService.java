package com.feri.shop.newretail.search.service;

import com.feri.shop.newretail.common.vo.R;
import com.feri.shop.newretail.search.entity.SearchGoods;

import java.util.List;

public interface SearchGoodsService {
    //1、批量新增
    R batchAdd(List<SearchGoods> list);
    //2、批量删除
    R batchDel(List<SearchGoods> ids);

    R queryKey(String key);
}
