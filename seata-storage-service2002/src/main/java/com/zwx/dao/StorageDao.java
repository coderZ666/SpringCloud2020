package com.zwx.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author coderZWX
 * @date 2020-12-28 21:13
 */
@Mapper
public interface StorageDao {
    /**
     * 减库存
     * @param productId 产品id
     * @param count 库存减少数量（订单数量）
     */
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}
