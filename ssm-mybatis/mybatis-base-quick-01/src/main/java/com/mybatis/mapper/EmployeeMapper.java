package com.mybatis.mapper;

import com.mybatis.pojo.Employee;

/**
 * ClassName:EmployeeMapper.xml
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/28 1:53
 * @Version 1.0
 */
public interface EmployeeMapper {

    // 查询员工id
    public Employee queryById(Integer id);

    // 删除员工
    public int deleteById(Integer id);
}
