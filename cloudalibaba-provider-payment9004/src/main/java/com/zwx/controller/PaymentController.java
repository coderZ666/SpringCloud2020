package com.zwx.controller;

import com.zwx.domain.CommonResult;
import com.zwx.domain.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.UUID;

/**
 * @author coderZWX
 * @date 2020-12-27 21:48
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    private static HashMap<Long, Payment> hashMap = new HashMap<>();
    static {
        hashMap.put(1L,new Payment(1L, UUID.randomUUID().toString().replace("-","")));
        hashMap.put(2L,new Payment(2L, UUID.randomUUID().toString().replace("-","")));
        hashMap.put(3L,new Payment(3L, UUID.randomUUID().toString().replace("-","")));
    }

    @GetMapping("/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id")Long id){
        Payment payment = hashMap.get(id);
        CommonResult<Payment> result = new CommonResult<>(200,"静态快hashMap模拟数据库，serverPort："+serverPort,payment);
        return result;
    }

}
