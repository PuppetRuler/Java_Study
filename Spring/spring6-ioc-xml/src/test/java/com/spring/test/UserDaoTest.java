package com.spring.test;

import com.spring.iocxml.bean.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName:UserDaoTest
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/24 23:04
 * @Version 1.0
 */
public class UserDaoTest {
    @Test
    public void testUserDao(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean.xml");
        // 根据类型获取接口对应bean
        UserDao userDao = context.getBean(UserDao.class);
        System.out.println(userDao);
        userDao.run();
    }
}
