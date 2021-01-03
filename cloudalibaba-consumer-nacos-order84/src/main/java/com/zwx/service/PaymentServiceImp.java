package com.zwx.service;

import com.zwx.domain.CommonResult;
import com.zwx.domain.Payment;
import org.springframework.stereotype.Component;

/**
 * @author coderZWX
 * @date 2020-12-27 22:53
 */
@Component
public class PaymentServiceImp implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult(444,"服务降级返回，OpenFeign的fallback",new Payment(id,"error"));
    }
}
