package com.springmvc.config;

import com.springmvc.interceptor.MyInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

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
@ComponentScan({"com.springmvc.controller","com.springmvc.error"})
public class MvcConfig implements WebMvcConfigurer {
    //开启静态资源查找
    // dispatcherServlet -> handlerMapping找有没有对应的handler -》【 没有 -》 找有没有静态资源 】

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    //添加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //配置方案1： 拦截全部请求
        // registry.addInterceptor(new MyInterceptor());

        //配置方案2： 指定地址拦截 .addPathPatterns("/user/data");
        //   *  任意一层字符串   ** 任意多层字符串
        // registry.addInterceptor(new MyInterceptor())
        //         .addPathPatterns("/user/**");

        //配置方案3：排除拦截 排除的地址应该在拦截地址内部！
        registry.addInterceptor(new MyInterceptor())
                .addPathPatterns("/user/**")
                .excludePathPatterns("/user/data1");
    }
}
