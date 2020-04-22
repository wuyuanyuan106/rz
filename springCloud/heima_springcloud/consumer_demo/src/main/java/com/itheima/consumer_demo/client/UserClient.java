package com.itheima.consumer_demo.client;

import com.itheima.consumer_demo.config.FeignConfig;
import com.itheima.consumer_demo.fallback.UserClientFallback;
import com.itheima.consumer_demo.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@Component
@FeignClient(value = "user-service",fallback = UserClientFallback.class,configuration = FeignConfig.class)
public interface UserClient {
    @GetMapping("/user/{id}")
    User getUserByID(@PathVariable("id") long id);
}
