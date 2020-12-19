package com.zwx.dao;

import com.zwx.domain.Payment;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author coderZWX
 * @date 2020-11-20 17:13
 */
@Mapper
public interface PaymentDao {

    public int create(Payment payment);

    public Payment getPaymentById(Long id);

}
