package com.itheima.consumer_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
//@SpringCloudApplication
@EnableFeignClients
public class applic {
    public static void main(String[] args) {
        SpringApplication.run(applic.class, args);
    }
//    @Bean("restTemplate")
//    @LoadBalanced
//    public RestTemplate getTemplete(){
//        return new RestTemplate();
//    }
}
