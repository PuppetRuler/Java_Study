package com.atguigu.api.utils;

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

        //编写SQL语句结果，动态值的部分使用？代替
        String sql = "insert into t_user(account,password,nickname) values(?,?,?);";

        BaseDao.executeUpdate(sql, "ciallo", "ciallo", "四季");
    }

    @Test
    public void testUpdate() throws ClassNotFoundException, SQLException {
        // 编写SQL语句结果，动态值的部分使用？代替
        String sql = "update t_user set nickname =? where id =?";

        BaseDao.executeUpdate(sql, "夏目", 3);
    }

    @Test
    public void testDelete() throws ClassNotFoundException, SQLException {
        // 编写SQL语句结果，动态值的部分使用？代替
        String sql = "delete from t_user where id =?";

        BaseDao.executeUpdate(sql,4);
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
