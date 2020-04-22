package com.itheima.user_service.service;

import com.itheima.user_service.domain.User;
import com.itheima.user_service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @PackageName: com.itheima.user_service.service
 * @ClassName: UserService
 * @Author: zhangle @Date: 2020/2/25 20:55
 * @Description:
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User getUserById(long id){
        List<User> users = userMapper.selectAll();
        User user = users.get(0);
        return user;
    }
}
