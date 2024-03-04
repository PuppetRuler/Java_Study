package com.spring.test;

import com.spring.iocxml.factoryBean.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName:FactoryTest
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/25 16:49
 * @Version 1.0
 */
public class FactoryTest {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-factorybean.xml");
        User user = (User)context.getBean("user");
        System.out.println(user);
    }

}
