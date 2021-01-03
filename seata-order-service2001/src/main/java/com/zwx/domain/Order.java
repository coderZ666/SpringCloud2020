package com.zwx.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author coderZWX
 * @date 2020-12-28 20:32
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    //订单id
    private Long id;
    //用户id
    private Long userId;
    //产品id
    private Long productId;
    //订单数量
    private Integer count;
    //订单总金额
    private BigDecimal money;
    //订单状态：0创建中，1已完成
    private Integer status;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", productId=" + productId +
                ", count=" + count +
                ", money=" + money +
                ", status=" + status +
                '}';
    }
}
