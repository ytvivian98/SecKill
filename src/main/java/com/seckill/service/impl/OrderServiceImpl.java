package com.seckill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.seckill.mapper.OrderMapper;
import com.seckill.pojo.Order;
import com.seckill.service.OrderService;
import org.springframework.stereotype.Service;

/**
* @author yutin
* @description 针对表【t_order】的数据库操作Service实现
* @createDate 2022-08-18 16:24:38
*/
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order>
    implements OrderService{

}




