package com.springmvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * ClassName:MvcConfig
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/3/2 17:57
 * @Version 1.0
 */
@EnableWebMvc
@Configuration
@ComponentScan("com.springmvc.controller")
public class MvcConfig implements WebMvcConfigurer {
    // 处理jsp页面
    // handlerMapping handlerAdapter json转化器
    // 视图解析器，指定前后锥
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/views/",".jsp");
    }

    //开启静态资源查找
    // dispatcherServlet -> handlerMapping找有没有对应的handler -》【 没有 -》 找有没有静态资源 】

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
