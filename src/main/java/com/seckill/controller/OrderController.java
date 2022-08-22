package com.seckill.controller;

import com.seckill.pojo.User;
import com.seckill.service.OrderService;
import com.seckill.vo.OrderDetailVo;
import com.seckill.vo.RespBean;
import com.seckill.vo.RespBeanEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yt
 * date 2022-08-22
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/detail")
    @ResponseBody
    public RespBean detail(User user,Long orderId){
        if(user == null){
            return RespBean.error(RespBeanEnum.SESSION_ERROR);
        }
       OrderDetailVo detail= orderService.detail(orderId);
        return RespBean.success(detail);
    }
}
