package com.atguigu.springcloud.service;


import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;

/**
 * @author MrChen
 * @create 2021-12-10 15:27
 */

public interface PaymentService{

    public int create(Payment payment);

     public Payment getPaymentById(Long id);

}
