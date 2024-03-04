package com.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * ClassName:Main
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/3/3 23:51
 * @Version 1.0
 */
//1.配置类 @SpringBootConfiguration
//2.自动加载配置 @EnableAutoConfiguration 自动加载其他的配置类
//3.@ComponentScan 默认是当前类所在的包,子包的注解
@SpringBootApplication // 启动类
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class,args); // 自动创建Ioc容器，启动tomcat服务器软件
    }
}
