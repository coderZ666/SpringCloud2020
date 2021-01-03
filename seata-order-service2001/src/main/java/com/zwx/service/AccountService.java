package com.zwx.service;

import com.zwx.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author coderZWX
 * @date 2020-12-28 20:46
 */
@FeignClient(value = "seata-account-service")
public interface AccountService {

    /**
     * 减余额
     * @param userId 用户id
     * @param money 订单金额
     * @return 封装的标准返回结果
     */
    @PostMapping(value = "account/decrease")
    CommonResult decrease(@RequestParam("userId") Long userId,@RequestParam("money") BigDecimal money);

}
