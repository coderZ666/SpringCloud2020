package com.zwx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CloudGatewayGateway9527Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudGatewayGateway9527Application.class, args);
    }

}
