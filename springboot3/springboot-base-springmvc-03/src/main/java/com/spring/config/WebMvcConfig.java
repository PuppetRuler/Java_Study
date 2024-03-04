package com.spring.config;

import com.spring.interceptor.MyInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * ClassName:WebMvcConfig
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/3/4 1:31
 * @Version 1.0
 */
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor());
    }
}
