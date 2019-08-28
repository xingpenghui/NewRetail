package com.feri.shop.newretail.order.service.impl;

import com.alibaba.fastjson.JSON;
import com.feri.shop.newretail.common.config.RedisKeyConfig;
import com.feri.shop.newretail.common.renum.OrderStatusEnum;
import com.feri.shop.newretail.common.util.IdGenerator;
import com.feri.shop.newretail.common.util.JedisUtil;
import com.feri.shop.newretail.common.vo.R;
import com.feri.shop.newretail.dto.OrderNowDto;
import com.feri.shop.newretail.entity.cart.CartItem;
import com.feri.shop.newretail.entity.order.Order;
import com.feri.shop.newretail.entity.order.OrderItem;
import com.feri.shop.newretail.entity.order.OrderStatus;
import com.feri.shop.newretail.entity.user.User;
import com.feri.shop.newretail.order.dao.OrderDao;
import com.feri.shop.newretail.order.dao.OrderItemDao;
import com.feri.shop.newretail.order.dao.OrderStatusDao;
import com.feri.shop.newretail.order.provider.GoodsRepertoryProvider;
import com.feri.shop.newretail.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * @program: NewRetail
 * @description:
 * @author: Feri
 * @create: 2019-08-28 11:41
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private OrderItemDao itemDao;
    @Autowired
    private OrderStatusDao statusDao;

    private JedisUtil jedisUtil;

    @Autowired
    private IdGenerator idGenerator;
    @Autowired
    private GoodsRepertoryProvider repertoryProvider;

    //立即下单
    @Override
    @Transactional
    public R saveOrder(String token, OrderNowDto nowDto) {
        //下单逻辑
        //1、解析用户
        User user= JSON.parseObject(jedisUtil.get(RedisKeyConfig.JWTTOKEN+token),User.class);
        //优惠抵扣
        //虚拟货币抵扣

        //2、生成订单
        Order order=new Order();

        String id=System.currentTimeMillis()+"_"+idGenerator.nextId();
        order.setId(id);
        order.setUid(user.getId());
        order.setPrice(nowDto.getPrice());
//        order.setAid();
        //为订单赋值
        //3、保存订单
        orderDao.insert(order);
        //4、更改库存  一定要防止超卖
        repertoryProvider.change(nowDto.getGskuid(),nowDto.getNum());
        //5、订单状态生成
        OrderStatus orderStatus=new OrderStatus();
        orderStatus.setOid(id);
        orderStatus.setFlag(OrderStatusEnum.CREATEORDER.getCode());
        statusDao.insert(orderStatus);
       //6、生成订单详情
        OrderItem item=new OrderItem();

        itemDao.insert(item);
        //7、订单流水




        return R.setOK("下单成功");
    }

    @Override
    public R saveOrder(List<CartItem> itemList) {
        return null;
    }

    //订单 默认 2小时  指的是下单到付款结束的时间
    @Override
    public R queryOrderTime() {

        return null;
    }

    //取消订单 未支付订单  释放库存
    @Override
    public R cancelOrder(String oid) {
        return null;
    }
}
