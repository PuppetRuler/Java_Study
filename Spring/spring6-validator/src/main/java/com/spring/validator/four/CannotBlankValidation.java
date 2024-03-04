package com.spring.validator.four;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.annotation.Annotation;

/**
 * ClassName:CannotBlankValidation
 * Description:
 *  编写真正的校验类
 * @Author Sixty-three
 * @Create 2024/2/27 16:21
 * @Version 1.0
 */
public class CannotBlankValidation implements ConstraintValidator<CannotBlank,String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        //null时不进行校验
        if (value != null && value.contains(" ")) {
            //获取默认提示信息
            String defaultConstraintMessageTemplate = context.getDefaultConstraintMessageTemplate();
            System.out.println("default message :" + defaultConstraintMessageTemplate);
            //禁用默认提示信息
            context.disableDefaultConstraintViolation();
            //设置提示语
            context.buildConstraintViolationWithTemplate("can not contains blank").addConstraintViolation();
            return false;
        }
        return true;
    }

    @Override
    public void initialize(CannotBlank constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
}
