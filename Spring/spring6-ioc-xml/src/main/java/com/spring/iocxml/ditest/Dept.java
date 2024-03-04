package com.spring.iocxml.ditest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//部门类
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dept {

    //一个部门有很多员工
    private List<Emp> empList;

    private String dname;

    public void info() {
        System.out.println("部门名称："+dname);
        for (Emp emp:empList) {
            System.out.println(emp.getEname());
        }
    }
}
