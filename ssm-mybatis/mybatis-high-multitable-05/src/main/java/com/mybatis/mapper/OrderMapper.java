package com.mybatis.mapper;

import com.mybatis.pojo.Order;

/**
 * ClassName:CustomerMapper
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/29 18:58
 * @Version 1.0
 */
public interface OrderMapper {

    // 根据id查询订单
    public Order queryOrderById(Integer id);
}
