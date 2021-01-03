package com.zwx.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author coderZWX
 * @date 2020-12-27 17:14
 */
@RestController
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA(){
        return "测试A";
    }

    @GetMapping("/testB")
    public String testB(){
        return "测试B";
    }

}
