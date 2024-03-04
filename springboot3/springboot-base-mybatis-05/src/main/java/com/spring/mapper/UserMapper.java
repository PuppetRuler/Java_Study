package com.spring.mapper;

import com.spring.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ClassName:UserMapper
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/3/4 11:36
 * @Version 1.0
 */
@Mapper
public interface UserMapper {
    List<User> getAll();

    int delete(int id);
}
