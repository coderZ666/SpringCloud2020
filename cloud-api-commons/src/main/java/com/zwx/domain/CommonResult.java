package com.zwx.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Json封装实体
 * @author coderZWX
 * @date 2020-11-20 17:09
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    //404 not_found
    private Integer code;
    //消息
    private String message;
    //数据
    private T      data;

    public CommonResult(Integer code, String message){
        this(code,message,null);
    }

}
