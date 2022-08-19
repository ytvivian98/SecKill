package com.seckill.controller;

import com.seckill.pojo.User;
import com.seckill.service.GoodsService;
import com.seckill.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 商品
 * @author yt
 * date 2022-08-17
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private UserService userService;

    @Autowired
    private GoodsService goodsService;

    /**
     * 跳转到商品列表页面
     * @param model
     * @return
     */
    @RequestMapping("/toList")
    public String toList( Model model,User user)
    {
//        if(StringUtils.isBlank(ticket))
//        {
//            return "login";
//        }
//        //User user = (User) session.getAttribute(ticket);
//        User user = userService.getUserByCookie(ticket, request, response);
//        if(user == null){
//            return "login";
//        }
        model.addAttribute("user",user);
        model.addAttribute("goodsList",goodsService.findGoodsVo());
        return "goodsList";
    }

    /**
     * 跳转商品详情页
     * @param goodsId
     * @return
     */
    @RequestMapping("/toDetail/{goodsId}")
    public String toDetail(Model model, User user, @PathVariable Long goodsId){
        model.addAttribute("user",user);
        model.addAttribute("goods",goodsService.findGoodsVoByGoodsId(goodsId));
        return "goodsDetail";
    }
}
