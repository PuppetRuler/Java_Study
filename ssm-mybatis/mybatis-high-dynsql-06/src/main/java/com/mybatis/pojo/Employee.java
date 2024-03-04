package com.mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName:Employee
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/28 1:47
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private Integer empId;

    private String empName;

    private Double empSalary;

}
