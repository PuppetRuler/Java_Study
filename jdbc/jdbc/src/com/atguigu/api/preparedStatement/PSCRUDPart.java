package com.atguigu.api.preparedStatement;

import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName:PSCRUDPart
 * Description: 使用preparedStatement对表进行crud操作
 *
 * @Author Sixty-three
 * @Create 2024/2/8 2:22
 * @Version 1.0
 */
public class PSCRUDPart {
    @Test
    public void testInsert() throws ClassNotFoundException, SQLException {
        /*
         * 向t_user插入一条数据
         *   account ciallo
         *   password ciallo
         *   nickname 四季
         * */

        //1.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.获取连接
        Connection connection = DriverManager.getConnection("jdbc:mysql:///atguigu_jdbc?user=root&password=root");
        //3.编写SQL语句结果，动态值的部分使用？代替
        String sql = "insert into t_user(account,password,nickname) values(?,?,?);";
        //4,创建preparedStatement,并且传入SQL语句结果
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //5.占位符赋值
        preparedStatement.setObject(1, "ciallo");
        preparedStatement.setObject(2, "ciallo");
        preparedStatement.setObject(3, "四季");
        //6.发送SQL语句
        int rows = preparedStatement.executeUpdate();
        //7.输出结果
        if (rows > 0) {
            System.out.println("插入成功");
        } else {
            System.out.println("插入失败");
        }
        //8.关闭资源
        preparedStatement.close();
        connection.close();
    }

    @Test
    public void testUpdate() throws ClassNotFoundException, SQLException {
        // 1.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 2.获取连接
        Connection connection = DriverManager.getConnection("jdbc:mysql:///atguigu_jdbc?user=root&password=root");
        // 3.编写SQL语句结果，动态值的部分使用？代替
        String sql = "update t_user set nickname =? where id =?";
        // 4,创建preparedStatement,并且传入SQL语句结果
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        // 5.占位符赋值
        preparedStatement.setObject(1, "四季夏目");
        preparedStatement.setObject(2, 3);
        // 6.发送SQL语句
        int i = preparedStatement.executeUpdate();
        // 7.输出结果
        if (i > 0) {
            System.out.println("更新成功");
        } else {
            System.out.println("更新失败");
        }
        // 8.关闭资源
        preparedStatement.close();
        connection.close();
    }

    @Test
    public void testDelete() throws ClassNotFoundException, SQLException {
        // 1.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 2.获取连接
        Connection connection = DriverManager.getConnection("jdbc:mysql:///atguigu_jdbc?user=root&password=root");
        // 3.编写SQL语句结果，动态值的部分使用？代替
        String sql = "delete from t_user where id =?";
        // 4,创建preparedStatement,并且传入SQL语句结果
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        // 5.占位符赋值
        preparedStatement.setObject(1, 3);
        // 6.发送SQL语句
        int i = preparedStatement.executeUpdate();
        // 7.输出结果
        if (i > 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
        // 8.关闭资源
        preparedStatement.close();
        connection.close();
    }

    /**
     * 查询全部数据!
     * 将数据存到List<Map>中
     * map -> 对应一行数据
     * map key -> 数据库列名或者别名
     * map value -> 数据库列的值
     * TODO: 思路分析
     *    1.先创建一个List<Map>集合
     *    2.遍历resultSet对象的行数据
     *    3.将每一行数据存储到一个map对象中!
     *    4.将对象存到List<Map>中
     *    5.最终返回
     * 注：如何获取列名？！！！！！！！！！
     * TODO:
     *    初体验,结果存储!
     *    学习获取结果表头信息(列名和数量等信息)
     */
    @Test
    public void testSelect() throws Exception {
        // 1. 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 2. 获取连接
        Connection connection = DriverManager.getConnection("jdbc:mysql:///atguigu_jdbc", "root", "root");
        // 3.创建statement
        Statement statement = connection.createStatement();
        // 4. 编写sql语句
        String sql = "select id,account from t_user";
        // 5. 传入sql语句返回结果
        ResultSet resultSet = statement.executeQuery(sql);
        // 6. 解析结果集
        List<Map> list = new ArrayList();
        while (resultSet.next()) {
            Map map = new HashMap();
            ResultSetMetaData metaData = resultSet.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                //笨蛋写法：
                //map.put("id",resultSet.getInt("id"));好几行，写法固定
                //value:获取指定下角标的值 key；用metaData
                //getColumnLabel先获取列的别名，没有别名用列名，而getColumnName只是列名
                map.put(metaData.getColumnLabel(i), resultSet.getObject(i));
            }
            list.add(map);
        }
        System.out.println("list:" + list);
        // 7. 关闭资源
        resultSet.close();
        statement.close();
        connection.close();
    }
}
