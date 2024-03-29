package com.spring.springi18n;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.Locale;

/**
 * ClassName:ResourceI18n
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/27 15:22
 * @Version 1.0
 */
public class ResourceI18n {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean.xml");

        Object[] objs = new Object[]{"atguigu",new Date().toString()};
        String value = context.getMessage("www.atguigu.com", objs, Locale.CHINA);
        System.out.println(value);
    }
}
