package com.spring.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:HelloController
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/3/3 23:53
 * @Version 1.0
 */
@RestController
@RequestMapping("hello")
public class HelloController {

    @Value("${puppet.name}")
    private String username;

    @GetMapping("boot")
    public String hello(){
        System.out.println(username);
        return "hello springboot";
    }
}
