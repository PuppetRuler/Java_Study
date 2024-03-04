package com.mybatis.mapper;

import com.mybatis.pojo.User;

import java.util.List;

/**
 * ClassName:UserMapper
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/29 11:54
 * @Version 1.0
 */

public interface UserMapper {

    int insert(User user);

    int update(User user);

    int delete(Integer id);

    User selectById(Integer id);

    List<User> selectAll();
}