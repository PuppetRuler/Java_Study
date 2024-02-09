package com.atguigu.api.utils;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:BaseDao
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/9 14:08
 * @Version 1.0
 */
public abstract class BaseDao {
    /**
     * 封装非DQL语句
     *
     * @param sql    非DQL语句
     * @param params 非DQL语句参数
     * @return rows
     * @throws SQLException
     */
    public static int executeUpdate(String sql, Object... params) throws SQLException {
        Connection connection = JdbcUtilsV2.getConnection();

        // 4,创建preparedStatement,并且传入SQL语句结果
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        // 5.占位符赋值
        for (int i = 1; i < params.length; i++) {
            preparedStatement.setObject(i, params[i - 1]);
        }
        // 6.发送SQL语句 DML类型
        int rows = preparedStatement.executeUpdate();

        preparedStatement.close();
        // 是否回收连接，要考虑是不是事务
        if (connection.getAutoCommit()) {
            // 没有开启事务
            JdbcUtilsV2.freeConnection();
        }
        // 开启事务了，不要管连接，业务层处理

        return rows;
    }

    /**
     * 将查询结果封装到一个实体类集合！
     * @param clazz 要接值的实体类集合的模板对象
     * @param sql   查询语句，要求列名或者别名等于实体类的属性名！ u_id as uId => uId
     * @param params    占位符的值 要和？位置对象传递
     * @return  查询的实体类集合
     * @param <T>   声明的结果的类型
     * @throws SQLException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws NoSuchFieldException
     */
    public <T> List<T> executeQuery(Class<T> clazz, String sql, Object... params) throws SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        // 获取连接
        Connection connection = JdbcUtilsV2.getConnection();

        PreparedStatement statement = connection.prepareStatement(sql);

        //占位符赋值
        if(params != null && params.length > 0){
            for (int i = 1; i < params.length; i++) {
                statement.setObject(i, params[i - 1]);
            }
        }

        // 发送sql语句
        ResultSet resultSet = statement.executeQuery();

        // 结果集解析
        List<T> list = new ArrayList<>();

        //获取列的信息对象
        //TODO:metaData装的当前结果集列的信息对象！（他可以获取列的名称根据下角标，可以获取列的数量）
        ResultSetMetaData metaData = resultSet.getMetaData();

        // 列的数量
        int columnCount = metaData.getColumnCount();

        while (resultSet.next()) {
            // 调用类的无参构造器实例化对象
            T t = clazz.newInstance();

            for (int i = 1; i < columnCount; i++) {

                // 对象的属性名
                String propertyName = metaData.getColumnLabel(i);
                // 对象的属性值
                Object value = resultSet.getObject(i);

                // 反射，给对象的属性值赋值
                Field field = clazz.getDeclaredField(propertyName);
                field.setAccessible(true); // 属性可以设置，打破private的修饰限制
                /**
                 * 参数1：要赋值的对象  如果属性是静态，第一个参数可以为null
                 * 参数2：具体的属性值
                 */
                field.set(t, value);
            }
        }

        // 关闭资源
        resultSet.close();
        statement.close();
        if(connection.getAutoCommit()) {
            JdbcUtilsV2.freeConnection(); // 如果没有事务，回收连接
        }

        return list;
    }
}
