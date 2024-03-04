package com.mybatis.mapper;

import com.mybatis.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ClassName:EmployeeMapper
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/29 20:18
 * @Version 1.0
 */
public interface EmployeeMapper {
    List<Employee> query(@Param("name") String name, @Param("salary") Double salary);

    List<Employee> queryTrim(@Param("name") String name, @Param("salary") Double salary);

    List<Employee> queryChoose(@Param("name") String name, @Param("salary") Double salary);

    int update(@Param("employee") Employee employee);

    int updateTrim(@Param("employee") Employee employee);

    // 根据id批量查询
    List<Employee> queryBatch(@Param("ids") List<Integer> ids);

    // 根据id的批量删除
    List<Employee> deleteBatch(@Param("ids") List<Integer> ids);

    int insertBatch(@Param("employeeList") List<Employee> employeeList);

    int updateBatch(@Param("employeeList") List<Employee> employeeList);
}
