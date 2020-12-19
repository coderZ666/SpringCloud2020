package com.zwx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroservicecloudConfigClient3355Application {

    public static void main(String[] args) {
        SpringApplication.run(MicroservicecloudConfigClient3355Application.class, args);
    }

}
