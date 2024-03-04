package com.springmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * ClassName:MvcConfig
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/3/2 0:35
 * @Version 1.0
 */
@EnableWebMvc // 为handlerAdapter配置了json转换器
@Configuration
@ComponentScan("com.springmvc.json")
public class MvcConfig {

    // @Bean
    // public RequestMappingHandlerAdapter requestMappingHandlerAdapter(){
    //     return new RequestMappingHandlerAdapter();
    // }
    //
    // @Bean
    // public RequestMappingHandlerMapping requestMappingHandlerMapping(){
    //     return new RequestMappingHandlerMapping();
    // }
}
