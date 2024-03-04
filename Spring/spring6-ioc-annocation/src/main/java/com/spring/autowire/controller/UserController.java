package com.spring.autowire.controller;


import com.spring.autowire.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * ClassName:UserController
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/25 17:00
 * @Version 1.0
 */
@Controller()
public class UserController {

    // 注入dao
    // 第一种方式 属性注入
    // @Autowired // 根据类型找到对应对象，完成注入    相当于<bean name="..." ref="..."/>
    // private UserService userService;

    // 第二种方式 set注入
    // private UserService userService;
    //
    // @Autowired
    // public void setUserService(UserService userService) {
    //     this.userService = userService;
    // }

    // 第三种方式 构造方法注入
    // private UserService userService;
    //
    // @Autowired
    // public UserController(UserService userService) {
    //     this.userService = userService;
    // }

    // 第四种方式 行参上注入
    // private UserService userService;
    //
    // public UserController(@Autowired UserService userService) {
    //     this.userService = userService;
    // }

    // 第五种方式 只有一个有参数构造函数，无注解
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void addUser(){
        System.out.println("Controller执行");
        userService.addUser();
    }
}
