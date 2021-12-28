package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author MrChen
 * @create 2021-12-22 21:50
 */

@Slf4j
@RestController
/**
 * @DefaultProperties(defaultFallback = "payment_Global_Handle")
 * 这个处理的自身的80端口号如果出现问题，进行服务降级处理
 */
@DefaultProperties(defaultFallback = "payment_Global_Handle")
public class OrderHystirxController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id)
    {
        return paymentHystrixService.paymentInfo_OK(id);
    }

    /**
     * 有服务降级功能
     * @param id
     * @return
     * @throws InterruptedException
     */
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandle",commandProperties = {
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="1500")
//    })
    @HystrixCommand
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) throws InterruptedException
    {
        /**
         * 模拟出现服务问题
         */
//        int k=10;
//        int i = k / 0;

        return paymentHystrixService.paymentInfo_TimeOut(id);
    }

    /**
     * 全局默认服务降级处理办法
     * @param
     * @return
     */
    public String payment_Global_Handle(){

        return  "/(ㄒoㄒ)/Global_Handle超时或异常：\t"+ "\t当前线程池名字" + Thread.currentThread().getName();
    }


}
