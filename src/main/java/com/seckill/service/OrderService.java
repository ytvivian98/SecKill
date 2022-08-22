package com.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.seckill.pojo.Order;
import com.seckill.pojo.User;
import com.seckill.vo.GoodsVo;
import com.seckill.vo.OrderDetailVo;

/**
* @author yutin
* @description 针对表【t_order】的数据库操作Service
* @createDate 2022-08-18 16:24:38
*/
public interface OrderService extends IService<Order> {

    /**
     * 秒杀
     * @param user
     * @param goods
     * @return
     */
    Order seckill(User user, GoodsVo goods);

    /**
     * 订单详情
     * @param orderId
     * @return
     */
    OrderDetailVo detail(Long orderId);
}
