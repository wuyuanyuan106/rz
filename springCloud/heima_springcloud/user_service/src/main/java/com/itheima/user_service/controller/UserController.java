package com.itheima.user_service.controller;

import com.itheima.user_service.domain.User;
import com.itheima.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @PackageName: com.itheima.user_service.controller
 * @ClassName: UserController
 * @Author: zhangle @Date: 2020/2/25 20:59
 * @Description:
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") long id){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        User user = userService.getUserById(id);
        System.out.println(user);
        return user;
    }
}
