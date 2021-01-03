package com.zwx.service;

import java.math.BigDecimal;

/**
 * @author coderZWX
 * @date 2020-12-28 21:32
 */
public interface AccountService {
    /**
     * 减库存
     * @param userId 用户id
     * @param money  金额
     */
    void decrease(Long userId, BigDecimal money);
}
