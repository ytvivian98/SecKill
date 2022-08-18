package com.seckill.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.seckill.pojo.Goods;
import com.seckill.vo.GoodsVo;

import java.util.List;

/**
* @author yutin
* @description 针对表【t_goods】的数据库操作Mapper
* @createDate 2022-08-18 16:24:26
* @Entity com.xxxx.generator.pojo.Goods
*/
public interface GoodsMapper extends BaseMapper<Goods> {

    /**
     * 获取商品列表
     * @return
     */
    List<GoodsVo> findGoodsVo();
}




