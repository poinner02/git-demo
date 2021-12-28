package com.atguigu.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author MrChen
 * @create 2021-12-17 19:12
 */
@Configuration
public class ApplicationContextBean {

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
