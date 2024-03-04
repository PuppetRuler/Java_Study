package com.spring.validator.two;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

/**
 * ClassName:User
 * Description:
 * 第二步 创建实体类，使用注解定义校验规则
 *      @NotNull 限制必须不为null
 *      @NotEmpty 只作用于字符串类型，字符串不为空，并且长度不为0
 *      @NotBlank 只作用于字符串类型，字符串不为空，并且trim()后不为空串
 *      @DecimalMax(value) 限制必须为一个不大于指定值的数字
 *      @DecimalMin(value) 限制必须为一个不小于指定值的数字
 *      @Max(value) 限制必须为一个不大于指定值的数字
 *      @Min(value) 限制必须为一个不小于指定值的数字
 *      @Pattern(value) 限制必须符合指定的正则表达式
 *      @Size(max,min) 限制字符长度必须在min到max之间
 *      @Email 验证注解的元素值是Email，也可以通过正则表达式和flag指定自定义的email格式
 *
 *      @Author Sixty-three
 *      @Create 2024/2/27 15:48
 *      @Version 1.0
 */
public class User {

    @NotNull
    public String name;
    @Min(0)
    @Max(150)
    public int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
