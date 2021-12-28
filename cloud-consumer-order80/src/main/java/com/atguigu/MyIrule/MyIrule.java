package com.atguigu.MyIrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author MrChen
 * @create 2021-12-17 21:16
 */
@Configuration
public class MyIrule {

    @Bean
    public IRule myRule()
    {
        return new RandomRule();//定义为随机
    }

}
