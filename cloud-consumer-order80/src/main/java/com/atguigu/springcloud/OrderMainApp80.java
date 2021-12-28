package com.atguigu.springcloud;

import com.atguigu.MyIrule.MyIrule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;


/**
 * @author MrChen
 * @create 2021-12-10 19:19
 */

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration= MyIrule.class)
public class OrderMainApp80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMainApp80.class, args);
    }

}
