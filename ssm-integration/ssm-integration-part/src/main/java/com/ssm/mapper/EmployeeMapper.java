package com.ssm.mapper;

import com.ssm.pojo.Employee;

import java.util.List;

/**
 * ClassName:EmployeeMapper
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/3/3 17:22
 * @Version 1.0
 */
public interface EmployeeMapper {

    // 查询员工的全部信息
    List<Employee> queryList();

}
