package com.zwx.service;

import com.zwx.domain.Payment;

/**
 * @author coderZWX
 * @date 2020-11-20 17:28
 */
public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(Long id);

}
