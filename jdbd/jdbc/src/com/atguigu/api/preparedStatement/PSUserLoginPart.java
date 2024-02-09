package com.atguigu.api.preparedStatement;

import java.sql.*;
import java.util.Scanner;

/**
 * ClassName:PSUserLoginPart
 * Description:
 *  TODO: 防止注入攻击 | 演示ps的使用流程
 * @Author Sixty-three
 * @Create 2024/2/7 23:02
 * @Version 1.0
 */
public class PSUserLoginPart {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1. 获取输入
        Scanner scanner = new Scanner(System.in);
        System.out.println("account:");
        String account = scanner.nextLine();
        System.out.println("password:");
        String password = scanner.nextLine();

        // ps的sql流程
        // 2. 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 3. 获取连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/atguigu_jdbc?user=root&password=root");
        /*
          statement
            1.创建statement
            2.拼接SQL语句
            3.发送SQL语句，并且获取返回结果
          preparedStatement
            1.编写SQL语句结果不包含动态值部分的语句，动态值部分使用占位符 ？ 替代注意： ？ 只能替代动态值
            2.创建preparedStatement,并且传入动态值
            3.动态值占位符赋值 ？ 单独赋值即可
            4.发送SQL语句即可，并获取返回结果
        * */

        // 4. 编写sql语句的结果
        String sql = "select * from t_user where account = ? and password = ?";
        // 5. 创建预编译statement并且设置SQL语句结果
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        // 6. 单独的占位符进行赋值
        /*
          参数1：index占位符的位置从左向右数从1开始 账号 ？ 1
          参数2：object占位符的值可以设置任何类型的数据，避免了我们拼接和类型更加丰富！
        * */
        preparedStatement.setString(1, account);
        preparedStatement.setString(2, password);

        // 6.发送SQL语句，并获取返回结果！
        // statement.executeUpdate executeQuery(string sql);
        // preparedStatement.executeUpdate|executeQuery();  TODO:因为它已经知道语句，知道语句动态值！
        ResultSet resultSet = preparedStatement.executeQuery();

        // 7. 结果集解析
        if(resultSet.next()){
            System.out.println("登录成功");
        } else {
            System.out.println("登录失败");
        }
    }
}














