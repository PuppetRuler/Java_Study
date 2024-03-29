package com.spring.validator.three;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestUser {

    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(ValidationConfig.class);
        MyService service = context.getBean(MyService.class);
        User user = new User();
        user.setName("lucy");
        user.setPhone("13566754321");
    }
}
