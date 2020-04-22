package com.itheima.consumer_demo.controller;

import com.itheima.consumer_demo.domain.User;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @PackageName: com.itheima.consumer_demo.controller
 * @ClassName: ConsumerController
 * @Author: zhangle @Date: 2020/2/25 21:52
 * @Description:
 */
@RestController
@RequestMapping("/consumer")
@Slf4j
@DefaultProperties(defaultFallback="defaultFallback")
public class ConsumerController {

//    @Autowired
//    private RestTemplate restTemplate;

    /*@Autowired
    private DiscoveryClient discoveryClient;*/
//    @GetMapping("/{id}")
//    @HystrixCommand(fallbackMethod="queryByIdFallback")
//    @HystrixCommand
//    public String getUser(@PathVariable("id") long id){
//        if (id == 1){
//            throw new RuntimeException("太忙了");
//        }
//        return restTemplate.getForObject("http://user-service/user/1",String.class);
//    }
    public String queryByIdFallback(@PathVariable("id") long id){
        log.error("查询用户信息失败。id：{}", id);
        return "对不起，网络太拥挤了！";
    }
    public String defaultFallback(){
        return "对不起，网络太拥挤了！......";
    }
}
