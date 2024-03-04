package com.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:HelloController
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/3/4 1:13
 * @Version 1.0
 */
@RestController
@RequestMapping("hello")
public class HelloController {

    @GetMapping("data")
    public String hello(){
        return "hello springboot";
    }
}
