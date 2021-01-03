package com.zwx.service;

import com.zwx.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author coderZWX
 * @date 2020-12-28 20:46
 */
@FeignClient("seata-storage-service")
public interface StorageService {

    /**
     * 减库存
     * @param productId 产品id
     * @param count 库存消耗数量（订单数量）
     * @return 封装的标准返回值
     */
    @PostMapping(value = "storage/decrease")
    CommonResult decrease(@RequestParam("productId") Long productId,@RequestParam("count") Integer count);

}
