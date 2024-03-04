package com.spring.test;

import com.spring.iocxml.di.Book;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName:SetterTest
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/25 13:08
 * @Version 1.0
 */
public class SetterTest {
    @Test
    public void testSetter(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-di.xml");
        Book book = (Book)context.getBean("book");
        System.out.println(book);
    }

    @Test
    public void testCon(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-di.xml");
        Book book = (Book)context.getBean("bookCon");
        System.out.println(book);
    }

}
