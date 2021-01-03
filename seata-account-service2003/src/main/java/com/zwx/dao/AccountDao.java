package com.zwx.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author coderZWX
 * @date 2020-12-28 21:31
 */
@Mapper
public interface AccountDao {
    /**
     * 扣减账户余额
     * @param userId 用户id
     * @param money 消费金额
     * @return 扣除成功的条数
     */
    int decrease(@Param("userId") Long userId,@Param("money") BigDecimal money);
}
