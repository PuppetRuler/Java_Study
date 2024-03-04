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
 * 内部包含一个连接池对象，并且对外提供获取连接和回收连接的方法
 * 建议：工具类的方法推荐写成静态的，外部调用会更加方便！
 * 实现：
 *      属性 连接池对象[实例化一次]
 *      单例模式
 *      static{
 *          全局调用一次
 *      }
 *      方法
 *          对外提供连接的方法
 *          回收外部传入连接方法
 *
 * @Author Sixty-three
 * @Create 2024/2/9 2:09
 * @Version 1.0
 */
public class JdbcUtils {
    private static DataSource dataSource = null;

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
        }catch (Exception e) {
            throw new IllegalStateException();
        }
    }

    /**
     * 对外提供连接的方法
     */
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static void freeConnection(Connection connection) throws SQLException {
        connection.close(); // 回收连接
    }


}
