package com.spring.test;

import com.spring.iocxml.ditest.Emp;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpTest {

    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean-ditest.xml");
        //员工对象
        Emp emp = context.getBean("emp", Emp.class);
        emp.work();
    }
}
