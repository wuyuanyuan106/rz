package com.itheima.consumer_demo.fallback;

import com.itheima.consumer_demo.client.UserClient;
import com.itheima.consumer_demo.domain.User;
import org.springframework.stereotype.Component;

/**
 * @PackageName: com.itheima.consumer_demo.client.fallback
 * @ClassName: UserClientFallback
 * @Author: zhangle @Date: 2020/2/28 17:46
 * @Description:
 */
@Component
public class UserClientFallback implements UserClient {

    @Override
    public User getUserByID(long id) {
        User user = new User();
        user.setId(id);
        user.setName("用户异常");
        return user;
    }
}
