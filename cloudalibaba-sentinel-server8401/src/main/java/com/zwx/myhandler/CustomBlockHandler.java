package com.zwx.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zwx.domain.CommonResult;

/**
 * @author coderZWX
 * @date 2020-12-27 21:24
 */
public class CustomBlockHandler {

    public static CommonResult handleException(BlockException exception){
        return new CommonResult(2020,"自定义全局限流处理方法");
    }

}
