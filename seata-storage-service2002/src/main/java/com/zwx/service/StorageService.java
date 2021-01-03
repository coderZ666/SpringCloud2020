package com.zwx.service;

/**
 * @author coderZWX
 * @date 2020-12-28 21:16
 */
public interface StorageService {

    /**
     * 减库存
     * @param productId 产品id
     * @param count 库存减少数量（订单数量）
     * @return 成功减库存的条数
     */
    void decrease(Long productId, Integer count);

}
