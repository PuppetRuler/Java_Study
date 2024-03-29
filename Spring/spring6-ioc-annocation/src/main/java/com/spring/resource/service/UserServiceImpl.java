package com.spring.resource.service;

import com.spring.resource.dao.UserDao;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("myUserService")
public class UserServiceImpl  implements UserService {

    //不指定名称，根据属性名称进行注入
    @Resource
    private UserDao myUserDao;

    @Override
    public void add() {
        System.out.println("service.....");
        myUserDao.add();
    }
}
