package com.spring.dao.impl;

import com.spring.anno.Bean;
import com.spring.dao.UserDao;

/**
 * ClassName:UserDaoImpl
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/25 22:33
 * @Version 1.0
 */
@Bean
public class UserDaoImpl implements UserDao {

    @Override
    public void add() {
        System.out.println("dao...");
    }
}
