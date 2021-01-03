package com.zwx.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zwx.domain.CommonResult;
import com.zwx.domain.Payment;
import com.zwx.myhandler.CustomBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author coderZWX
 * @date 2020-12-27 19:54
 */
@RestController
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",
            //设置全局兜底方法所在类
            blockHandlerClass = CustomBlockHandler.class,
            //设置全局方法名
            blockHandler = "handleException")
    public CommonResult byResource(){
        return new CommonResult(200,"按资源名称限流测试OK",new Payment(2020L,"serial001"));
    }
    //Sentinel限流降级兜底
    public CommonResult handleException(BlockException exception){
        return new CommonResult(444,exception.getClass().getCanonicalName()+"\t服务不可用");
    }

    @GetMapping("/byURL")
    @SentinelResource(blockHandler = "handleException")
    public CommonResult byURL(){
        return new CommonResult(200,"按资源路径限流测试OK",new Payment(2020L,"serial001"));
    }

}
