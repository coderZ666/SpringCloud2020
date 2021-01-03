package com.zwx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudalibabaSentinelServer8401Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudalibabaSentinelServer8401Application.class, args);
    }

}
