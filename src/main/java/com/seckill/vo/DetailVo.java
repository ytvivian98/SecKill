package com.seckill.vo;

import com.seckill.pojo.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 商品详情返回对象
 * @author yt
 * date 2022-08-22
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailVo {
    private User user;

    private GoodsVo goodsVo;

    private int secKillStatus;

    private int remainSeconds;
}
