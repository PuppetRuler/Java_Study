package com.springmvc.pojo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

/**
 * ClassName:User
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/3/2 23:04
 * @Version 1.0
 */
public class User {
    @NotBlank
    private String name;

    @Length(min = 6)
    private String password;

    @Min(1)
    private int age;

    @Email
    private String email;

    @Past
    private Date birthday;
}
