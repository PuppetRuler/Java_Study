package com.spring.controller;

import com.spring.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:UserController
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/3/4 0:53
 * @Version 1.0
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private User user;

    @GetMapping("show")
    public User show(){
        return user;
    }
}
