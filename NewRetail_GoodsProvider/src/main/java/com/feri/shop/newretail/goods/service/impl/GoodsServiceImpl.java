package com.feri.shop.newretail.goods.service.impl;

import com.feri.shop.newretail.common.config.RedisKeyConfig;
import com.feri.shop.newretail.common.util.JedisUtil;
import com.feri.shop.newretail.common.vo.R;
import com.feri.shop.newretail.goods.dao.GoodsDao;
import com.feri.shop.newretail.goods.dao.GoodsRepertoryDao;
import com.feri.shop.newretail.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: NewRetail
 * @description:
 * @author: Feri
 * @create: 2019-08-21 14:25
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsDao goodsDao;
    @Autowired
    private GoodsRepertoryDao repertoryDao;

    private JedisUtil jedisUtil=JedisUtil.getInstance();
    @Override
    public R queryLookTop() {
        List<String> j=jedisUtil.hvals(RedisKeyConfig.TOPLOOK);
        return R.setOK("OK",j);
    }

    @Override
    public R changeRepertory(int gskuid, int num) {
        repertoryDao.update(gskuid, num);
        return R.setOK("OK");
    }
}
