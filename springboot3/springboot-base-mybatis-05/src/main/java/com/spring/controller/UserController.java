package com.spring.controller;

import com.spring.mapper.UserMapper;
import com.spring.pojo.User;
import com.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ClassName:UserController
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/3/4 11:50
 * @Version 1.0
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAll(){
        List<User> users = userMapper.getAll();
        return users;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        userService.delete(id);
    }
}
