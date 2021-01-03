package com.zwx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient //开启服务注册与发现
public class CloudalibabaProviderPayment9001Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudalibabaProviderPayment9001Application.class, args);
    }

}
