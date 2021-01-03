package com.zwx.controller;

import com.zwx.domain.CommonResult;
import com.zwx.service.AccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author coderZWX
 * @date 2020-12-28 21:34
 */
@RestController
public class AccountController {

    @Resource
    private AccountService accountService;

    @PostMapping(value = "account/decrease")
    public CommonResult decrease(Long userId,BigDecimal money) {
        accountService.decrease(userId, money);
        return new CommonResult(200, "扣减账户余额成功");
    }

}
