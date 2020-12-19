package com.zwx.service;

import org.springframework.stereotype.Component;

/**
 * @author coderZWX
 * @date 2020-12-13 11:53
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "实现接口解耦 Fallback paymentInfo_OK，(┬＿┬)";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "实现接口解耦 Fallback paymentInfo_OK，(┬＿┬)";
    }
}
