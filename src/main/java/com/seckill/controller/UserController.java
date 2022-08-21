package com.seckill.controller;

import com.seckill.pojo.User;
import com.seckill.vo.RespBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yt
 * date 2022-08-20
 */
@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 用户信息，专门用来测试
     * @param user
     * @return
     */
    @RequestMapping("/info")
    @ResponseBody
    public RespBean info(User user){
        return RespBean.success(user);
    }
}
