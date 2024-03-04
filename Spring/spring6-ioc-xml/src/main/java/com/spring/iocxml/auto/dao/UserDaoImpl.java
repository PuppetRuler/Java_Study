package com.spring.iocxml.auto.dao;

/**
 * ClassName:UserDaoImpl
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/25 17:02
 * @Version 1.0
 */
public class UserDaoImpl implements UserDao{



    @Override
    public void addUser() {
        System.out.println("Dao执行");
    }
}
