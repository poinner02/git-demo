package com.atguigu.springcloud.service.Imp;

import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author MrChen
 * @create 2021-12-10 15:28
 */

@Service
public class PaymentServiceImp implements PaymentService {

    @Resource
    PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {

        Payment payment = paymentDao.getPaymentById(id);
        return payment;
    }
}
