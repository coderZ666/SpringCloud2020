package com.zwx.service;

import com.zwx.dao.PaymentDao;
import com.zwx.domain.Payment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author coderZWX
 * @date 2020-11-20 17:29
 */
@Service
public class PaymentServiceImp implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
