package com.mybatis.mapper;

import com.mybatis.pojo.Customer;
import com.mybatis.pojo.Order;

import java.util.List;

/**
 * ClassName:CustomerMapper
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/29 18:58
 * @Version 1.0
 */
public interface CustomerMapper {

    public List<Customer> queryList();

}
