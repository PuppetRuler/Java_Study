package com.spring.validator.three;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * ClassName:MyService
 * Description:
 *  第三步 定义Service类，通过注解操作对象
 *
 * @Author Sixty-three
 * @Create 2024/2/27 16:12
 * @Version 1.0
 */
@Service
@Validated
public class MyService {
    public String testParams(@NotNull @Valid User user) {
        return user.toString();
    }
}
