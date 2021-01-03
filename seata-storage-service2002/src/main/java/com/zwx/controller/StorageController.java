package com.zwx.controller;

import com.zwx.domain.CommonResult;
import com.zwx.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author coderZWX
 * @date 2020-12-28 21:18
 */
@RestController
@Slf4j
public class StorageController {

    @Resource
    private StorageService storageService;

    /**
     * 减库存
     */
    @PostMapping(value = "storage/decrease")
    public CommonResult decrease(Long productId,Integer count) {
        storageService.decrease(productId, count);
        return new CommonResult(200, "扣减库存成功");
    }

}
