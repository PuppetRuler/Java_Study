package com.springmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * ClassName:MvcConfig
 * Description:
 *  1. controller配置ioc容器
 *  2. handlerMapping  handlerAdapter加入到ioc容器
 * @Author Sixty-three
 * @Create 2024/3/1 15:36
 * @Version 1.0
 */

@Configuration
@ComponentScan("com.springmvc.controller")
public class MvcConfig {
    @Bean
    public RequestMappingHandlerMapping handlerMapping(){
        return new RequestMappingHandlerMapping();
    }

    @Bean
    public RequestMappingHandlerAdapter handlerAdapter(){
        return new RequestMappingHandlerAdapter();
    }
}
