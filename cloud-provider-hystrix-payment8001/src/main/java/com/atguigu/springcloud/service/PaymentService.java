package com.atguigu.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author MrChen
 * @create 2021-12-22 20:16
 */
@Service
/**
 * @DefaultProperties 注解解耦合
 */
@DefaultProperties(defaultFallback = "paymentCircuitBreaker_fallback",
commandProperties = {
        @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),
        @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
        @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
        @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),
})
public class PaymentService
{
    /**
     * 正常访问，一切OK
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id)
    {
        return "线程池:"+Thread.currentThread().getName()+"paymentInfo_OK,id: "+id+"\t"+"O(∩_∩)O";
    }

    /**
     * 超时访问，演示降级
     * 这个是没有解耦合的
     * @param id
     * @return
     */

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandle",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="5000")
    })
    public String paymentInfo_TimeOut(Integer id)
    {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池:"+Thread.currentThread().getName()+"paymentInfo_TimeOut,id: "+id+"\t"+"O(∩_∩)O，耗费3秒";
    }


    public String paymentInfo_TimeOutHandle(Integer id){

        return "/(ㄒoㄒ)/调用支付接口超时或异常：\t"+ "\t当前线程池名字" + Thread.currentThread().getName();
    }


    //服务熔断技术
//    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
//            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),
//            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
//            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
//            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),
//    })
    @HystrixCommand
    public String  paymentCircuitBreaker(@PathVariable("id") Integer id){
        if(id < 0){
            throw  new RuntimeException("====不能为负数");
        }else{
            String serialNumber = IdUtil.simpleUUID();
            return Thread.currentThread().getName()+"\t"+"调用成功，流水号: " + serialNumber;
        }
    }


    /**
     * 服务熔断回调接口
     * @return
     */
    public String paymentCircuitBreaker_fallback()
    {
        return "id 不能负数，请稍后再试，/(ㄒoㄒ)/~~   id: ";
    }
}


