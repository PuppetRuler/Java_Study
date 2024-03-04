package com.spring.iocxml.auto.controller;

import com.spring.iocxml.auto.service.UserService;

/**
 * ClassName:UserController
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/25 17:00
 * @Version 1.0
 */
public class UserController {

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void addUser(){
        System.out.println("Controller执行");
        userService.addUser();
    }
}
