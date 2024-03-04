package com.mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * ClassName:Customer
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/29 18:56
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    private Integer customerId;
    private String customerName;
    // 一个客户对应多个订单
    private List<Order> orderList;
}
