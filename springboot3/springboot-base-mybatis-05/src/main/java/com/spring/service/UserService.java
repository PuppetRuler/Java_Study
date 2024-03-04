package com.spring.service;

import com.spring.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
 * ClassName:UserServcie
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/3/4 12:09
 * @Version 1.0
 */
@Service
public interface UserService {

    void delete(int id);
}
