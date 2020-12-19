package com.zwx.controller;

import com.zwx.domain.CommonResult;
import com.zwx.domain.Payment;
import com.zwx.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @author coderZWX
 * @date 2020-11-20 18:29
 */
@RestController
@Slf4j
public class OrderController {

    //单机版
    //private static final String PAYMENT_URL = "http://localhost:8001";
    //集群版
    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;
    @Resource
    private LoadBalancer loadBalancer;
    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }

    @GetMapping("consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }

    @GetMapping("/consumer/payment/lb")
    public String getPaymentLB(){
        //获取注册中心注册的所有CLOUD-PAYMENT-SERVICE服务
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances == null || instances.size()<=0){
            return null;
        }
        //调用自己写的负载均衡策略方法选择需要调用的服务
        ServiceInstance serviceInstance = loadBalancer.instances(instances);
        //获取需要调用的服务地址
        URI uri = serviceInstance.getUri();
        //调用服务
        return restTemplate.getForObject(uri+"/payment/lb",String.class);
    }

}
