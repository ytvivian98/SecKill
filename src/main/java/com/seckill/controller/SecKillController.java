package com.seckill.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.seckill.pojo.Order;
import com.seckill.pojo.SeckillOrder;
import com.seckill.pojo.User;
import com.seckill.service.GoodsService;
import com.seckill.service.OrderService;
import com.seckill.service.SeckillOrderService;
import com.seckill.vo.GoodsVo;
import com.seckill.vo.RespBean;
import com.seckill.vo.RespBeanEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 秒杀
 * @author yt
 * date 2022-08-19
 */
@Controller
@RequestMapping("/secKill")
public class SecKillController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private SeckillOrderService seckillOrderService;

    @Autowired
    private OrderService orderService;

    /**
     * windows优化前QPS：603.8/sec
     * Linux优化前QPS： //这里我的Linux中没有吧秒杀订单写进去，不知道为啥
     * 秒杀,页面静态化前的版本
     * @param model
     * @param user
     * @param goodsId
     * @return
     */
    @RequestMapping("/doSecKill2")
    public String doSecKill2(Model model, User user, Long goodsId){
        if(user==null){
            return "login";
        }
        model.addAttribute("user",user);
        GoodsVo goods = goodsService.findGoodsVoByGoodsId(goodsId);
        //判断库存
        if(goods.getStockCount() < 1){
            model.addAttribute("errMsg", RespBeanEnum.EMPTY_STOCK);
            return "secKillFail";
        }
        //判断是否重复抢购
        SeckillOrder serviceOrder = seckillOrderService.getOne(new QueryWrapper<SeckillOrder>().eq("user_id", user.getId()).eq("goods_id", goodsId));
        if(serviceOrder!=null){
            model.addAttribute("errMsg",RespBeanEnum.REPEATE_ERROR);
            return "secKillFail";
        }
        Order order = orderService.seckill(user,goods);
        model.addAttribute("order",order);
        model.addAttribute("goods",goods);
        return "orderDetail";
    }

    /**
     * windows优化前QPS：603.8/sec
     * Linux优化前QPS： //这里我的Linux中没有吧秒杀订单写进去，不知道为啥
     * 秒杀
     * @param model
     * @param user
     * @param goodsId
     * @return
     */
    @RequestMapping(value = "/doSecKill",method = RequestMethod.POST)
    @ResponseBody
    public RespBean doSecKill(Model model, User user, Long goodsId){
        if(user==null){
            return RespBean.error(RespBeanEnum.SESSION_ERROR);
        }
        GoodsVo goods = goodsService.findGoodsVoByGoodsId(goodsId);
        //判断库存
        if(goods.getStockCount() < 1){
            return RespBean.error(RespBeanEnum.EMPTY_STOCK);
        }
        //判断是否重复抢购
        SeckillOrder serviceOrder = seckillOrderService.getOne(new QueryWrapper<SeckillOrder>().eq("user_id", user.getId()).eq("goods_id", goodsId));
        if(serviceOrder!=null){
            return RespBean.error(RespBeanEnum.REPEATE_ERROR);
        }
        Order order = orderService.seckill(user,goods);

        return RespBean.success(order);
    }
}
