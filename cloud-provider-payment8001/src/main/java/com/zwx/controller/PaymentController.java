package com.zwx.controller;

import com.zwx.domain.CommonResult;
import com.zwx.domain.Payment;
import com.zwx.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author coderZWX
 * @date 2020-11-20 17:31
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;
    //添加私有属性表明端口号
    @Value("${server.port}")
    private String serverPort;
    @Resource
    private DiscoveryClient discoveryClient;

    //@RequestBody 注解的作用是——可以将Json字符串的内容绑定到实体Bean对象
    //也就是说通过其他服务调用时传递的值将是一个Json字符串，就可以接收了
    @PostMapping("/payment/create")
    public CommonResult creat(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("插入结果："+result);
        if (result > 0){
            return new CommonResult(200,"插入数据库成功，端口号："+serverPort,result);
        }else {
            return new CommonResult(444,"插入数据库失败，端口号："+serverPort,null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        if (payment != null){
            return new CommonResult(200,"查询成功，端口号："+serverPort,payment);
        }else {
            return new CommonResult(444,"没有对应记录，查询ID："+id+"，端口号："+serverPort,null);
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("***** element:"+element);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }

    //测试自己的负载均衡策略
    @GetMapping("/payment/lb")
    public String getPaymentLB() {
        return serverPort;
    }

    //测试超时
    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout(){
        try {
            //暂停3s钟
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

}
