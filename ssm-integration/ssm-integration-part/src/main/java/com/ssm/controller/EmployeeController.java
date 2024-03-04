package com.ssm.controller;

import com.ssm.pojo.Employee;
import com.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ClassName:EmployeeController
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/3/3 12:15
 * @Version 1.0
 */
@RestController
@RequestMapping("emp")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("find")
    public List<Employee> find(){
        List<Employee> employees = employeeService.queryList();
        return employees;
    }
}