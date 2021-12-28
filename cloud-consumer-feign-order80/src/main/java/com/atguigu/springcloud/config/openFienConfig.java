package com.atguigu.springcloud.config;

import feign.Feign;
import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author MrChen
 * @create 2021-12-21 20:58
 */

@Configuration
public class openFienConfig
{

    @Bean
    Logger.Level feignLoggerliver()
    {

        return Logger.Level.FULL;
    }
}
