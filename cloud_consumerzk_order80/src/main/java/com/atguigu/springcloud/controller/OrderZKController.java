package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author MrChen
 * @create 2021-12-17 19:14
 */

@RestController
@Slf4j
public class OrderZKController {
    private String pathVal = "http://CLOUD_PROVIDER_PAVMENT";

    @Resource
    RestTemplate restTemplate;

    @GetMapping("/consumer/order")
    public void Order(){
        restTemplate.getForObject(pathVal+"/payment/zk", CommonResult.class);
    }
}
