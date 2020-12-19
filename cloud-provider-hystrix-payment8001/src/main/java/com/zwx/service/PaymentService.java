package com.zwx.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author coderZWX
 * @date 2020-12-12 13:05
 */
@Service
public class PaymentService {
    /**
     * 正常访问
     */
    public String paymentInfo_OK(Integer id) {
        System.out.println("sssss");
        return "线程池:" + Thread.currentThread().getName() + " paymentInfo_OK,id:" + id + "\t" + "O(∩_∩)O哈哈~";
    }

    /**
     * 超时访问,降级演示
     */
    @HystrixCommand(fallbackMethod = "payment_TimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String paymentInfo_TimeOut(Integer id) {
        System.out.println(new Date()+"我开始执行了");
        //int age = 10/0;
        int timeNumber = 3;
        try {
            // 暂停3秒钟
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(new Date()+"我执行完了");
        return "线程池:" + Thread.currentThread().getName() + " id:" + id + "\t" +
                "O(∩_∩)O哈哈~  耗时(秒)" + timeNumber;
    }
    public String payment_TimeOutHandler(Integer id){
        return "线程池:" + Thread.currentThread().getName() + " 8001系统繁忙或者运行出错，请稍后再试" + "\t" +
                "(┬＿┬)";
    }

    //服务熔断------------------------------------------
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),
            //请求次数——表示在滚动时间窗（默认10秒）中，请求数量在10（默认20）以下无论如何都不会触发断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
            //休眠时间窗口期——表示断路器开启后，多长时间以后尝试断路器半开恢复
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
            //失败率达到多少熔断——前提是请求数量达到了requestVolumeThreshold的要求
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),
    })
    public String paymentCircuitBreaker(Integer id){
        if (id<0){
            throw new RuntimeException("id不能为负数："+id);
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"\t"+"调用成功，流水号："+serialNumber;
    }
    public String paymentCircuitBreaker_fallback(Integer id){
        if (id<0){
            return "id不能为负数："+id+"\t"+"请稍后再试(┬＿┬)";
        }
        return "服务器故障，请等待10秒后再试(┬＿┬)";
    }

}

