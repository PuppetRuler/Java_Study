package com.spring.test;

import com.spring.iocxml.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName:UserTest
 * Description:
 *          控制反转
 * @Author Sixty-three
 * @Create 2024/2/24 22:50
 * @Version 1.0
 */
public class UserTest {
    @Test
    public void testUser() {
        // 1 根据id获取bean
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean.xml");
        User user1 = (User) context.getBean("user");

        // 2 根据类型获取
        User user2 = context.getBean(User.class);

        // 3 根据id和类型
        User user3 = context.getBean("user", User.class);
    }
}
