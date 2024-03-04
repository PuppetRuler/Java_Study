package com.spring.test;

import com.spring.iocxml.life.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName:LifeTest
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/25 16:33
 * @Version 1.0
 */
public class LifeTest {
    @Test
    public void test(){
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("bean-life.xml");
        User user = context.getBean("user", User.class);
        System.out.println("6 bean对象创建完成了，可以使用了");
        System.out.println(user);
        context.close(); //销毁
    }
}
