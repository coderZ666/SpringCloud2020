package com.zwx.service;

import com.zwx.domain.Order;

/**
 * @author coderZWX
 * @date 2020-12-28 20:45
 */
public interface OrderService {

    /**
     * 创建订单
     * @param order 封装订单信息的实体类
     */
    void create(Order order);

}
