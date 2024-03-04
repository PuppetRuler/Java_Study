package com.mybatis.mapper;

import com.mybatis.pojo.Employee;

import java.util.List;

/**
 * ClassName:EmployeeMapper
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/3/1 13:56
 * @Version 1.0
 */
public interface EmployeeMapper {

    List<Employee> queryList();
}
