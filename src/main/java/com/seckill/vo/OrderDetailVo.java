package com.seckill.vo;

import com.seckill.pojo.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yt
 * date 2022-08-22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailVo {
    private Order order;
    private GoodsVo goodsVo;
}
