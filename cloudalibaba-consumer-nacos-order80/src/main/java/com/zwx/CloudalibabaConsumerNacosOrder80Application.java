package com.zwx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudalibabaConsumerNacosOrder80Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudalibabaConsumerNacosOrder80Application.class, args);
    }

}
