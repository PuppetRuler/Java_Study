package com.springmvc.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * ClassName:SpringMvcInit
 * Description:
 *  可以被web项目加载，会初始化ioc容器，会设置dispatcherServlet的地址
 * @Author Sixty-three
 * @Create 2024/3/1 15:44
 * @Version 1.0
 */
public class SpringMvcInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    // service层 mapper 的ioc容器的配置
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    // 设置项目对应的配置
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{MvcConfig.class};
    }

    // 配置springmvc内部自带servlet的访问地址
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
