package com.itheima.consumer_demo.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @PackageName: com.itheima.consumer_demo.config
 * @ClassName: FeignConfig
 * @Author: zhangle @Date: 2020/2/28 18:06
 * @Description:
 */
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
