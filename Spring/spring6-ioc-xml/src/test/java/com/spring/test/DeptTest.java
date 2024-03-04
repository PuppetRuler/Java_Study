package com.spring.test;

import com.spring.iocxml.ditest.Dept;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DeptTest {

    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean-ditest.xml");
        //员工对象
        Dept dept = context.getBean("dept", Dept.class);
        dept.info();
    }
}
