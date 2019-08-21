package com.feri.shop.newretail.search.task;

import com.alibaba.fastjson.JSON;
import com.feri.shop.newretail.common.config.RedisKeyConfig;
import com.feri.shop.newretail.common.util.JedisUtil;
import com.feri.shop.newretail.search.entity.SearchGoods;
import com.feri.shop.newretail.search.service.SearchGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @program: NewRetail
 * @description:
 * @author: Feri
 * @create: 2019-08-21 15:59
 */
@Component
public class EsGoodsTask {
    @Autowired
    private JedisUtil jedisUtil;
    @Autowired
    private SearchGoodsService goodsService;
    //4小时执行1次
    @Scheduled(cron = "0 0 0/4 * * ?")
    public void updateData(){
        //从Redis内容
        //新增
        changeES(RedisKeyConfig.ESGOODSADD,1);
        //修改
        changeES(RedisKeyConfig.ESGOODSUPDATE,1);
        //删除
        changeES(RedisKeyConfig.ESGOODSDEL,2);
    }

    private void changeES(String key,int t){
        Set<String> sets=jedisUtil.smembers(key);
        List<SearchGoods> list=new ArrayList<>(sets.size());
        for(String s:sets){
            list.add(JSON.parseObject(s,SearchGoods.class));
        }
        if(t==1){
            //新增或修改
            goodsService.batchAdd(list);
        }else if(t==2){
            //删除
            goodsService.batchDel(list);
        }
        jedisUtil.del(key);
    }
}
