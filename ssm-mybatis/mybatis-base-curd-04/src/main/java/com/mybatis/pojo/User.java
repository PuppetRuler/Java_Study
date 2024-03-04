package com.mybatis.pojo;

import lombok.Data;

/**
 * ClassName:User
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/29 11:55
 * @Version 1.0
 */
@Data //lombok  get set toString
public class User {
    private Integer id;
    private String username;
    private String password;
}
