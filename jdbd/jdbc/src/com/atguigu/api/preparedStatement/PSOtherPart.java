package com.atguigu.api.preparedStatement;

import org.junit.Test;

import java.sql.*;

/**
 * ClassName:PSOtherPart
 * Description:
 * 练习PS的特殊使用方法:主键回显和批量插入
 *
 * @Author Sixty-three
 * @Create 2024/2/8 15:32
 * @Version 1.0
 */
public class PSOtherPart {
    /**
     * 返回插入的主键！
     * 主键：数据库帮助维护的自增长的整数主键！
     *
     * @throws Exception
     */
    @Test
    public void ReturnPrimaryKey() throws Exception {
        // 1. 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 2. 获取连接
        Connection connection = DriverManager.getConnection("jdbc:mysql:///atguigu_jdbc?user=root&password=root");
        // 3.编写SQL语句结果，动态值的部分使用？代替
        String sql = "insert into t_user(account,password,nickname) values(?,?,?);";
        // 4.创建statement
        PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        // 5.占位符赋值
        statement.setString(1, "test1");
        statement.setString(2, "test1");
        statement.setString(3, "王五");
        // 6.发送SQL语句
        int i = statement.executeUpdate();
        // 7.结果解析
        if (i > 0) {
            System.out.println("插入数据成功");

            // 获取回显的主键
            // 获取司机装主键的结果集对象 一行一列 id = value
            ResultSet resultSet = statement.getGeneratedKeys();
            resultSet.next();
            int id = resultSet.getInt(1);
            System.out.println("id = " + id);
        } else {
            System.out.println("插入失败");
        }
        // 8.关闭资源
        statement.close();
        connection.close();
    }

    /**
     * 使用普通的方式插入一万行数据
     *
     * @throws Exception
     */
    @Test
    public void ReturnPrimaryKey2() throws Exception {
        // 1. 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 2. 获取连接
        Connection connection = DriverManager.getConnection("jdbc:mysql:///atguigu_jdbc?user=root&password=root");
        // 3.编写SQL语句结果，动态值的部分使用？代替
        String sql = "insert into t_user(account,password,nickname) values(?,?,?);";
        // 4.创建statement
        PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        long start = System.currentTimeMillis();
        for (int i = 0; i <= 10000; i++) {
            // 5.占位符赋值
            statement.setString(1, "tt" + i);
            statement.setString(2, "tt" + i);
            statement.setString(3, "王五" + i);
            // 6.发送SQL语句
            statement.executeUpdate();
        }
        // 7.结果解析
        long end = System.currentTimeMillis();
        long during = end - start; // 12013ms
        System.out.println("插入10000数据成功");
        System.out.println("time:" + during);
        // 8.关闭资源
        statement.close();
        connection.close();
    }

    /**
     * 使用批量插入的方式插入一万行数据
     *
     * 使用批量插入的的方式插入10000条数据
     * TODO:总结批量插入
     *      1.路径后面添加？rewriteBatchedStatements=true允许批量插入
     *      2.insert into valves[必须写]语句不能添加 ; 结束
     *      3.不是执行语句每条，是批量添加addBatch();
     *      4.遍历添加完毕以后，统一批量执行executeBatch()
     *
     * @throws Exception
     */

    @Test
    public void ReturnPrimaryKey3() throws Exception {
        // 1. 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 2. 获取连接
        Connection connection =
                DriverManager.getConnection("jdbc:mysql:///atguigu_jdbc?user=root&password=root&rewriteBitchedStatements=true");
        // 3.编写SQL语句结果，动态值的部分使用？代替
        String sql = "insert into t_user(account,password,nickname) values(?,?,?)";
        // 4.创建statement
        PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        long start = System.currentTimeMillis();
        for (int i = 0; i <= 10000; i++) {
            // 5.占位符赋值
            statement.setString(1, "ttt" + i);
            statement.setString(2, "ttt" + i);
            statement.setString(3, "王五t" + i);
            // 追加SQL语句
            statement.addBatch();
        }
        // 6.发送SQL语句
        statement.executeBatch();
        // 7.结果解析
        long end = System.currentTimeMillis();
        long during = end - start; // 13131ms
        System.out.println("插入10000数据成功");
        System.out.println("time:" + during);
        // 8.关闭资源
        statement.close();
        connection.close();
    }
}
