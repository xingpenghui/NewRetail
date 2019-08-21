package com.feri.shop.newretail.search.service.impl;

import com.feri.shop.newretail.common.vo.R;
import com.feri.shop.newretail.search.dao.SearchGoodsDao;
import com.feri.shop.newretail.search.entity.SearchGoods;
import com.feri.shop.newretail.search.service.SearchGoodsService;
import org.elasticsearch.index.query.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: NewRetail
 * @description:
 * @author: Feri
 * @create: 2019-08-21 16:16
 */
@Service
public class SearchGoodsServiceImpl implements SearchGoodsService {
    @Autowired
    private SearchGoodsDao searchGoodsDao;
    @Override
    public R batchAdd(List<SearchGoods> list) {
        searchGoodsDao.saveAll(list);
        return R.setOK("OK");
    }

    @Override
    public R batchDel(List<SearchGoods> ids) {
        searchGoodsDao.deleteAll(ids);
        return R.setOK("OK");
    }

    @Override
    public R queryKey(String key) {
        //关键字匹配查询
       MatchQueryBuilder matchQueryBuilder=QueryBuilders.matchQuery("name",key);
       return R.setOK("OK",searchGoodsDao.search(matchQueryBuilder));
    }


}
