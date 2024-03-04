package com.spring.validator.two;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;

import java.util.List;

/**
 * ClassName:MyValidator1
 * Description:
 *  使用org.springframework.validation.Validator校验
 * @Author Sixty-three
 * @Create 2024/2/27 15:52
 * @Version 1.0
 */
@Service
public class MyValidator2 {
    @Autowired
    private Validator validator;

    public boolean validatorByUserTwo(User user) {
        BindException bindException = new BindException(user,user.getName());
        validator.validate(user,bindException);
        List<ObjectError> allErrors = bindException.getAllErrors();
        System.out.println(allErrors);
        return bindException.hasErrors();
    }
}
