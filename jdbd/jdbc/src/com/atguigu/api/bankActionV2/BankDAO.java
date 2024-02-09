package com.atguigu.api.bankActionV2;

import com.atguigu.api.utils.JdbcUtilsV2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * ClassName:BankDAO
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/8 16:32
 * @Version 1.0
 */
public class BankDAO {
    /**
     * 加钱的数据库操作方法(jdbc)
     * @param account
     * @param money
     */
    public void add(String account, int money) throws SQLException {

        Connection connection = JdbcUtilsV2.getConnection();

        // 编写sql
        String sql = "update t_bank set money = money + ? where account = ?";
        // 创建statement
        PreparedStatement statement = connection.prepareStatement(sql);
        // 占位符赋值
        statement.setObject(1,money);
        statement.setObject(2,account);
        // 发送SQL语句
        statement.executeUpdate();
        System.out.println("加钱成功");
        // 关闭资源
        statement.close();
    }
    /**
     * 减钱的数据库操作方法(jdbc)
     * @param account
     * @param money
     */
    public  void sub(String account,int money) throws SQLException {

        Connection connection = JdbcUtilsV2.getConnection();

        // 编写sql
        String sql = "update t_bank set money = money - ? where account = ?";
        // 创建statement
        PreparedStatement statement = connection.prepareStatement(sql);
        // 占位符赋值
        statement.setObject(1,money);
        statement.setObject(2,account);
        // 发送SQL语句
        statement.executeUpdate();
        System.out.println("减钱成功");
        // 关闭资源
        statement.close();
    }
}
