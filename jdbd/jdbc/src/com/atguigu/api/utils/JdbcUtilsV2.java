package com.atguigu.api.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * ClassName:JdbcUtils
 * Description:
 *  内部包含一个连接池对象，并且对外提供获取连接和回收连接的方法
 *  建议：工具类的方法推荐写成静态的，外部调用会更加方便！
 *  实现：
 *      属性 连接池对象[实例化一次]
 *          单例模式
 *          static{
 *              全局调用一次
 *          }
 *      方法
 *          对外提供连接的方法
 *          回收外部传入连接方法
 * TODO:
 *  利用线程本地变量，存储连接信息！确保一个线程的多个方法可以获取同一个connection!
 *  优势：事务操作的时候service和dao属于同一个线程，不用再传递参数了！
 *  大家都可以调用getConnection自动获取的是相同的连接池！
 *
 * @Author Sixty-three
 * @Create 2024/2/9 2:09
 * @Version 1.0
 */
public class JdbcUtilsV2 {
    private static DataSource dataSource = null;
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    static {
        // 初始化连接池对象
        Properties properties = new Properties();
        InputStream ips = JdbcUtils.class.getClassLoader().getResourceAsStream("druid.properties");
        try {
            properties.load(ips);
        } catch (Exception e) {
            throw new IllegalStateException();
        }

        try {
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            throw new IllegalStateException();
        }
    }

    /**
     * 对外提供连接的方法
     */
    public static Connection getConnection() throws SQLException {

        // 线程本地变量中是否存在
        Connection connection = threadLocal.get();

        // 第一次没有
        if (connection == null) {
            // 线程本地变量没有，连接池中获取
            connection = dataSource.getConnection();

            // 线程本地变量中放入
            threadLocal.set(connection);
        }

        return connection;
    }

    public static void freeConnection() throws SQLException {
        Connection connection = threadLocal.get();
        if (connection != null) {
            threadLocal.remove(); // 情况线程本地变量
            connection.setAutoCommit(true); // 事物状态回归
            connection.close(); // 回收连接
        }
    }
}
