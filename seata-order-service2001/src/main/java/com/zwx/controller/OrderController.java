package com.zwx.controller;

import com.zwx.domain.CommonResult;
import com.zwx.domain.Order;
import com.zwx.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author coderZWX
 * @date 2020-12-28 20:58
 */
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    /**
     * 创建订单
     *
     * @param order 订单对象
     * @return 标准返回结果
     */
    @GetMapping("order/create")
    @GlobalTransactional(name = "fsp-create-order", rollbackFor = Exception.class)
    public CommonResult create(Order order) {
        System.out.println(order);
        orderService.create(order);
        return new CommonResult(200, "订单创建成功");
    }

}
