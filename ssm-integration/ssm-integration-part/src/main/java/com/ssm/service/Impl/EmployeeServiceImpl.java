package com.ssm.service.Impl;

import com.ssm.mapper.EmployeeMapper;
import com.ssm.pojo.Employee;
import com.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName:EmployeeServiceImpl
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/3/3 17:30
 * @Version 1.0
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> queryList() {
        List<Employee> employees = employeeMapper.queryList();
        return employees;
    }
}
