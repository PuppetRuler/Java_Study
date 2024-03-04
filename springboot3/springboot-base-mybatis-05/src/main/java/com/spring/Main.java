package com.spring;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * ClassName:Main
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/3/4 11:43
 * @Version 1.0
 */
@MapperScan("com.spring.mapper") // mapper接口所在位置
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
