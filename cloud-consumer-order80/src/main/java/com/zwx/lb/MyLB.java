package com.zwx.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author coderZWX
 * @date 2020-12-10 21:51
 */
@Component
public class MyLB implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement(){
        int current;//上一次是第几次访问服务
        int next;//当前是第几次访问服务
        do{
            current = this.atomicInteger.get();
            next = current >= 2147483647 ? 0 : current+1;
         //while后的条件
         // 1.这里是一个自旋锁，这里将返回false
         // 2.如果atomicInteger的值在current取值之后发生了更改
         // 3.将返回false继续执行do直到正确
        }while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("当前服务第几次被访问："+next);
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        //用第 几次访问服务 和 服务总数量 取余 得到这一次调用哪个服务
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
