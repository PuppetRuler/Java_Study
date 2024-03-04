package com.springmvc.controller;

import com.springmvc.pojo.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ClassName:UserController
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/3/2 22:50
 * @Version 1.0
 */
@RestController
@RequestMapping("user")
public class UserController {
    @GetMapping
    public List<User> getList(@RequestParam String page,@RequestParam String size){

        return null;
    }

    @PostMapping
    public User add(@RequestBody User user){

        return null;
    }

    @GetMapping("{id}")
    public User userInfoById(@PathVariable String id){

        return null;
    }

    @PutMapping
    public User update(@RequestBody User user){

        return null;
    }

    @DeleteMapping("{id}")
    public User delete(@PathVariable String id){

        return null;
    }

    @GetMapping("search")
    public List<User> search(String keywork,
                             @RequestParam(required = false,defaultValue = "1") int page,
                             @RequestParam(required = false,defaultValue = "10") int size){
        return null;
    }
}
