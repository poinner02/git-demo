package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author MrChen
 * @create 2021-12-23 20:41
 */

@Component
public class paymentFallback implements PaymentHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "paymentInfo_OK服务调用失败，提示来自：cloud-consumer-feign-order80";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "paymentInfo_TimeOut服务调用失败，提示来自：cloud-consumer-feign-order80";
    }
}
