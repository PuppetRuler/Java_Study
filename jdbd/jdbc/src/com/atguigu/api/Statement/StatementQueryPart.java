package com.atguigu.api.Statement;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;

/**
 * ClassName:StatementQueryPart
 * Description: 使用statement查询t_User表下，全部的数据
 *
 * @Author Sixty-three
 * @Create 2024/2/7 16:05
 * @Version 1.0
 */
public class StatementQueryPart {
    public static void main(String[] args) throws SQLException {
        // 1. 注册驱动
        /*
          TODO:
           注册驱动
           依赖：
               驱动版本 8+ com.mysql.cj.jdbc.Driver
               驱动版本 5+ com.mysql.jdbc.Driver
         */
        DriverManager.registerDriver(new Driver());
        // 2. 获取链接
        /*
           TODO:
            java程序要和数据库创建连接！
            java程序，连接数据库，肯定是调用某个方法，方法也需要填入连接数据库的基本信息：
                数据库IP地址127.0.0.1
                数据库端口号3306
                账号：root
                密码：root
                连接数据库的名称：atguigu_jdbc
        */
        /*
            参数1：url:
                jdbc:数据库厂商名://ip地址：port/数据库名
                jdbc:mysql://127.0.0.1:3306/atguigu_jdbc
            参数2：username 数据库软件的账号root
            参数3：password 数据库软件的密码root
        */
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/atguigu_jdbc", "root", "root");
        // 3. 创建statement
        Statement statement = connection.createStatement();
        // 4. 发送sql语句,并且获取返回结果
        String sql = "select * from t_user;";
        // 5. 进行结果集解析
        ResultSet resultSet = statement.executeQuery(sql);
        // 看看有没有下一行数据，有，你就可以获取
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String account = resultSet.getString("account");
            String password = resultSet.getString("PASSWORD");
            String nickname = resultSet.getString("nickname");
            System.out.println("id:"+id+" "+"account:"+account+" "+"password:"+password+" "+"nickname:"+nickname);
        }
        // 6. 关闭资源
        resultSet.close();
        statement.close();
        connection.close();
    }
}
