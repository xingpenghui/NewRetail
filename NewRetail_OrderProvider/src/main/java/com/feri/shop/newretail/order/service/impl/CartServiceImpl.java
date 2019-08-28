package com.feri.shop.newretail.order.service.impl;

import com.alibaba.fastjson.JSON;
import com.feri.shop.newretail.common.config.RedisKeyConfig;
import com.feri.shop.newretail.common.util.JedisUtil;
import com.feri.shop.newretail.common.vo.R;
import com.feri.shop.newretail.dto.CartItemDto;
import com.feri.shop.newretail.entity.cart.CartItem;
import com.feri.shop.newretail.entity.cart.CartLog;
import com.feri.shop.newretail.entity.user.User;
import com.feri.shop.newretail.order.dao.CartDao;
import com.feri.shop.newretail.order.dao.CartItemDao;
import com.feri.shop.newretail.order.dao.CartLogDao;
import com.feri.shop.newretail.order.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: NewRetail
 * @description:
 * @author: Feri
 * @create: 2019-08-27 16:10
 */
@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartDao cartDao;
    @Autowired
    private CartItemDao itemDao;
    @Autowired
    private CartLogDao logDao;

    private JedisUtil jedisUtil=JedisUtil.getInstance();

    @Override
    @Transactional
    public R saveCartItem(String token, CartItemDto itemDto) {
        //获取购物车id
        User user= JSON.parseObject(jedisUtil.get(RedisKeyConfig.JWTTOKEN+token),User.class);
        int cid=0;
        if(jedisUtil.exists(RedisKeyConfig.CART+user.getPhone())) {
            cid = Integer.parseInt(jedisUtil.get(RedisKeyConfig.CART + user.getPhone()));
        }
        else {
            //不存在购物车id 需要查询数据库
            cid=cartDao.selectCid(user.getId());
            //更新Redis的内容
            jedisUtil.set(RedisKeyConfig.CART+user.getPhone(),cid+"");
        }
        CartItem item = new CartItem();
        item.setCid(cid);
        item.setGskuid(itemDto.getGskuid());
        item.setNum(itemDto.getNum());
        item.setCartprice(itemDto.getPrice());
        itemDao.insert(item);
        logDao.insert(new CartLog(cid,"商品第一次加入购物车"));
        return R.setOK("添加购物车成功");
    }

    @Override
    public R queryUserCart(String token) {
        User user= JSON.parseObject(jedisUtil.get(RedisKeyConfig.JWTTOKEN+token),User.class);
        return R.setOK("OK",cartDao.selectByUid(user.getId()));
    }

    @Override
    @Transactional
    public R changeNum(String token,int id, int num) {
        itemDao.updateNum(id, num);
        User user= JSON.parseObject(jedisUtil.get(RedisKeyConfig.JWTTOKEN+token),User.class);
        int cid=Integer.parseInt(jedisUtil.get(RedisKeyConfig.CART + user.getPhone()));
        logDao.insert(new CartLog(cid,"更购物车中的商品数量"));
        return R.setOK("OK");
    }

    @Override
    @Transactional
    public R delCartItem(String token,int id) {
        itemDao.delById(id);
        User user= JSON.parseObject(jedisUtil.get(RedisKeyConfig.JWTTOKEN+token),User.class);
        int cid=Integer.parseInt(jedisUtil.get(RedisKeyConfig.CART + user.getPhone()));
        logDao.insert(new CartLog(cid,"删除购物者中的商品信息"));
        return R.setOK("OK");
    }

    @Override
    public R addCart(String token, CartItemDto itemDto) {
        User user= JSON.parseObject(jedisUtil.get(RedisKeyConfig.JWTTOKEN+token),User.class);
        //可能是新增
        CartItem ci=itemDao.selectGskuid(user.getId(),itemDto.getGskuid());
        if(ci==null){
           //是新增
           return saveCartItem(token, itemDto);
        }else {
            //修改
           itemDao.updateNum(ci.getId(),itemDto.getNum());
           return R.setOK("OK");
        }
    }
}