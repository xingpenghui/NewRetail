package com.feri.shop.newretail.goods.task;

import com.alibaba.fastjson.JSON;
import com.feri.shop.newretail.common.config.RedisKeyConfig;
import com.feri.shop.newretail.common.util.JedisUtil;
import com.feri.shop.newretail.dto.GoodsLookDto;
import com.feri.shop.newretail.entity.goods.GoodsLook;
import com.feri.shop.newretail.goods.dao.GoodsDao;
import com.feri.shop.newretail.goods.dao.GoodsLookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @program: NewRetail
 * @description:
 * @author: Feri
 * @create: 2019-08-21 14:54
 */
@Component
public class GoodsTask {
    @Autowired
    private GoodsDao goodsDao;
    @Autowired
    private JedisUtil jedisUtil;

    //定时同步商品浏览数据 每天凌晨3点  缺陷：定时不执行的时候，每日榜单未更新
    @Scheduled(cron = "0 0 3 * * ?")
    public void tbLook(){
        //发消息--开始定时

        List<GoodsLookDto> lookDtos=goodsDao.selectLookTop();
       // jedisUtil.del(RedisKeyConfig.TOPLOOK);
        int i=1;
        for(GoodsLookDto gl:lookDtos){
            jedisUtil.hset(RedisKeyConfig.TOPLOOK,(i++)+"", JSON.toJSONString(gl));
        }
        //发消息--已完成

    }
}
