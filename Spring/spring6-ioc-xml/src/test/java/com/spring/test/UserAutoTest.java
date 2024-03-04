package com.spring.test;

import com.spring.iocxml.auto.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName:UserAutoTest
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/25 17:17
 * @Version 1.0
 */
public class UserAutoTest {
    @Test
    public void testAuto(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-auto.xml");
        UserController userController = (UserController)context.getBean("userController");
        userController.addUser();
    }
}
