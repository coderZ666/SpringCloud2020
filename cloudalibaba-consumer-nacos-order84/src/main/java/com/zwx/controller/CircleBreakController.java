package com.zwx.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zwx.domain.CommonResult;
import com.zwx.domain.Payment;
import com.zwx.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author coderZWX
 * @date 2020-12-27 22:10
 */
@RestController
public class CircleBreakController {

    @Value("${service-url.nacos-user-service}")
    private String serviceURL;

    @Resource
    private PaymentService paymentService;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/fallback/{id}")
    @SentinelResource(value = "fallback",
            //Java中的异常处理兜底方法
            fallback = "handlerFallback",
            //Sentinel控制台限制后降级兜底方法
            blockHandler = "handlerBlock",
            //忽略某种异常不兜底不记录
            exceptionsToIgnore = {IllegalArgumentException.class})
    public CommonResult<Payment> fallback(@PathVariable("id")Long id){
        CommonResult result = restTemplate.getForObject(serviceURL + "/paymentSQL/" + id, CommonResult.class, id);

        if (id == 4){
            throw new IllegalArgumentException("非法参数异常......");
        }else if (result.getData() == null){
            throw new NullPointerException("该id没有对应记录，空指针异常");
        }

        return result;
    }
    //fallback兜底方法
    public CommonResult handlerFallback(Long id,Throwable e){
        Payment payment = new Payment(id,"null");
        return new CommonResult(444,"兜底异常fallback，异常信息："+e.getMessage(),payment);
    }
    //block兜底方法
    public CommonResult handlerBlock(Long id, BlockException e){
        Payment payment = new Payment(id,"null");
        return new CommonResult(444,"兜底异常Block，异常信息："+e.getMessage(),payment);
    }

    @GetMapping("/consumer/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id){
        return paymentService.paymentSQL(id);
    }

}
