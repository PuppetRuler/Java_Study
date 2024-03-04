package com.spring.autowire.service;


import com.spring.autowire.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * ClassName:UserServiceImpl
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/25 17:02
 * @Version 1.0
 */
@Service()
public class UserServiceImpl implements UserService {

    // @Autowired
    // private UserDao userDao;

    // private UserDao userDao;
    // @Autowired
    // public void setUserDao(UserDao userDao) {
    //     this.userDao = userDao;
    // }

    // private UserDao userDao;
    // @Autowired
    // public UserServiceImpl(UserDao userDao) {
    //     this.userDao = userDao;
    // }

    // private UserDao userDao;
    //
    // public UserServiceImpl(@Autowired UserDao userDao) {
    //     this.userDao = userDao;
    // }

    // 使用两个注解通过名称进行注入
    @Autowired
    @Qualifier(value = "userDaoImpl")
    private UserDao userDao;

    @Override
    public void addUser() {
        System.out.println("Service执行");
        userDao.addUser();
    }
}
