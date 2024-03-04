package com.spring.iocxml.auto.service;

import com.spring.iocxml.auto.dao.UserDao;

/**
 * ClassName:UserServiceImpl
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/25 17:02
 * @Version 1.0
 */
public class UserServiceImpl implements UserService{

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUser() {
        System.out.println("Service执行");
        userDao.addUser();
    }
}
