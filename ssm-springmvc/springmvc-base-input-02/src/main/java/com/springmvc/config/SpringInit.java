package com.springmvc.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * ClassName:SpringInit
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/3/2 1:14
 * @Version 1.0
 */
public class SpringInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    // springmvc需要组件的配置类
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{MvcConfig.class};
    }

    // Servlet DispatcherServlet
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
