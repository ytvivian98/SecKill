package com.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.seckill.pojo.Goods;
import com.seckill.vo.GoodsVo;

import java.util.List;

/**
* @author yutin
* @description 针对表【t_goods】的数据库操作Service
* @createDate 2022-08-18 16:24:26
*/
public interface GoodsService extends IService<Goods> {

    /**
     * 获取商品列表
     * @return
     */
    List<GoodsVo> findGoodsVo();
}
