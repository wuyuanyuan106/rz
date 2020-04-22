package com.itheima.consumer_demo.domain;

import lombok.Data;
import java.util.Date;

/**
 * @PackageName: com.itheima.consumer_demo.domain
 * @ClassName: User
 * @Author: zhangle @Date: 2020/2/25 21:47
 * @Description:
 */
@Data
public class User {
    private long id;
    private String username;
    private String password;
    private String name;
    private Integer age;
    private Integer sex;
    private Date birthday;
    private String note;
    private Date created;
    private Date updated;
}