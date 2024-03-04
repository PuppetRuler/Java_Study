package com.spring.service.impl;

import com.spring.anno.Bean;
import com.spring.anno.Di;
import com.spring.dao.UserDao;
import com.spring.service.UserService;

/**
 * ClassName:UserServiceImpl
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/25 22:34
 * @Version 1.0
 */
@Bean
public class UserServiceImpl implements UserService {
    @Di
    private UserDao userDao;

    @Override
    public void add() {
        System.out.println("service...");
        // 调用dao
        userDao.add();
    }
}
