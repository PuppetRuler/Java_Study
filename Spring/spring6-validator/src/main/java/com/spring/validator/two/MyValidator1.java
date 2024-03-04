package com.spring.validator.two;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * ClassName:MyValidator1
 * Description:
 *  使用jakarta.validation.Validator校验
 * @Author Sixty-three
 * @Create 2024/2/27 15:52
 * @Version 1.0
 */
@Service
public class MyValidator1 {
    @Autowired
    private Validator validator;

    public boolean validatorByUserOne(User user) {
        Set<ConstraintViolation<User>> validate = validator.validate(user);
        return validate.isEmpty();
    }
}
