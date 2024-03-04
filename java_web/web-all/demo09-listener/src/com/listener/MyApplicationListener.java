package com.listener;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebListener;

/**
 * ClassName:MyApplicationListener
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/19 14:20
 * @Version 1.0
 */
@WebListener
public class MyApplicationListener implements ServletContextListener, ServletContextAttributeListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext application = sce.getServletContext();
        System.out.println(application.hashCode()+"应用域初始化了～～");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext application = sce.getServletContext();
        System.out.println(application.hashCode()+"应用域销毁了～～");
    }

    // 监听数据增加
    @Override
    public void attributeAdded(ServletContextAttributeEvent scae) {
        String key = scae.getName();
        Object value = scae.getValue();
        ServletContext application = scae.getServletContext();
        System.out.println(application.hashCode()+"应用域增加了"+key+":"+value);
    }

    // 监听数据移除
    @Override
    public void attributeRemoved(ServletContextAttributeEvent scae) {
        String key = scae.getName();
        Object value = scae.getValue();
        ServletContext application = scae.getServletContext();
        System.out.println(application.hashCode()+"应用域移除了"+key+":"+value);
    }

    // 监听数据修改
    @Override
    public void attributeReplaced(ServletContextAttributeEvent scae) {
        String key = scae.getName();
        Object value = scae.getValue(); // 获取的是旧的值
        ServletContext application = scae.getServletContext();
        Object newValue = application.getAttribute(key); // 获取最新的值
        System.out.println(application.hashCode()+"应用域修改了"+key+":"+value+"为:"+newValue);
    }
}
