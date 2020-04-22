package com.itheima.consumer_demo.controller;

import com.itheima.consumer_demo.client.UserClient;
import com.itheima.consumer_demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @PackageName: com.itheima.consumer_demo.controller
 * @ClassName: ConsumerFeignController
 * @Author: zhangle @Date: 2020/2/28 11:09
 * @Description:
 */
@RestController
@RequestMapping("/cf")
public class ConsumerFeignController {
    @Autowired
    private UserClient userClient;
    @GetMapping("/{id}")
    public User getById(@PathVariable("id") long id){
        return userClient.getUserByID(id);
    }
}
