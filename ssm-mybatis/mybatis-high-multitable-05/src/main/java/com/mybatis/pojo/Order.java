package com.mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName:Order
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/29 18:57
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Integer orderId;
    private String orderName;
    private Integer customerId;
    private Customer customer;
}
