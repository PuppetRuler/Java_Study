package com.spring.test;

import com.spring.iocxml.dimap.Student;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StuTest {

    @Test
    public void testStu() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean-diref.xml");
        Student student = context.getBean("studentp", Student.class);
        student.run();
    }
}
