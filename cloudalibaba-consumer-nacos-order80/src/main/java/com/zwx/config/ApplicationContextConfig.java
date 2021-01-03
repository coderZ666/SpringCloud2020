package com.zwx.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author coderZWX
 * @date 2020-12-24 16:46
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced//赋予RestTemplate负载均衡的能力
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
