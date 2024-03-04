package com.spring.service.Impl;

import com.spring.mapper.UserMapper;
import com.spring.pojo.User;
import com.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ClassName:UserServiceImpl
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/3/4 12:11
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Transactional
    @Override
    public void delete(int id) {
        int rows = userMapper.delete(id);
        System.out.println("rows = " + rows);
        // int i = 1/0; // 除0异常
    }
}
