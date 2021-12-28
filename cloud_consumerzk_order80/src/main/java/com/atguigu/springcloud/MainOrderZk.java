package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author MrChen
 * @create 2021-12-17 19:11
 */

@SpringBootApplication
@EnableDiscoveryClient
public class MainOrderZk {

    public static void main(String[] args) {

        SpringApplication.run(MainOrderZk.class, args);
    }
}
