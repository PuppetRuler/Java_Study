package com.spring.validator.three;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName:User
 * Description:
 *  第二步 创建实体类，使用注解设置校验规则
 *
 * @Author Sixty-three
 * @Create 2024/2/27 16:08
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @NotNull
    private String name;
    @Min(0)
    @Max(150)
    private int age;
    @Pattern(regexp = "^1(3|4|5|7|8)\\d{9}$",message = "手机号码格式错误")
    @NotBlank(message = "手机号码不能为空")
    private String phone;
}
