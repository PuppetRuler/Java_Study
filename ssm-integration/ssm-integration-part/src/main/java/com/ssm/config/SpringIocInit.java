package com.ssm.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * ClassName:SpringIocInit
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/3/3 17:16
 * @Version 1.0
 */
public class SpringIocInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    // rootIoc容器的配置类
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{DataSourceConfig.class,ServiceConfig.class, NewMapperConfig.class};
    }

    //webIoc容器的配置类
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebMvcConfig.class};
    }

    // dispatcherServlet的拦截路径
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
