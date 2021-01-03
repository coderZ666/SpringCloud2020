package com.zwx.dao;

import com.zwx.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author coderZWX
 * @date 2020-12-28 20:39
 */
@Mapper
public interface OrderDao {

    /**
     * 创建订单
     * @param order 封装订单信息的实体类
     * @return 创建成功的数量
     */
    int create(Order order);

    /**
     * 修改订单状态，从0到1
     * @param userId 用户id
     * @param status 订单状态
     * @return 修改成功的数量
     */
    int update(@Param("userId") Long userId,@Param("status") Integer status);

}
