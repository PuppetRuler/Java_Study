package com.spring.iocxml.ditest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;

//员工类
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp {

    //对象类型属性：员工属于某个部门
    private Dept dept;
    //员工名称
    private String ename;
    //员工年龄
    private Integer age;

    //爱好
    private String[] loves;

    public void work() {
        System.out.println(ename+"emp work....."+age);
        dept.info();
        System.out.println(Arrays.toString(loves));
    }
}
