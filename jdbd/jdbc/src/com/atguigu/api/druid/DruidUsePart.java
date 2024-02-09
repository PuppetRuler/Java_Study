package com.atguigu.api.druid;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * ClassName:DruidUsePart
 * Description:
 *      druid连接池的用法
 * @Author Sixty-three
 * @Create 2024/2/8 21:09
 * @Version 1.0
 */
public class DruidUsePart {
    /*
     * 直接使用代码设置连接池连接参数方式！
     *
     * 1.创建一个druid连接池对象
     *
     * 2.设置连接池参数[必须/非必须]
     *
     * 3.获取连接[通用方法，所有连接池都一样]
     *
     * 4.回收连接[通用方法，所有连接池都一样]
     */
    public void useHard() throws SQLException {
        // 连接池对象
        DruidDataSource druidDataSource = new DruidDataSource();

        // 设置参数
        // 必须 连接池数据库驱动类的全限定符[注册驱动] url | user | password
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/atguigu_jdbc");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("root");
        druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver"); // 帮助我们进行驱动注册和获取连接
        // 非必要 初始化连接数量，最大的连接数量...
        druidDataSource.setInitialSize(5); // 初始化连接数量
        druidDataSource.setMaxActive(10); // 最大的连接数量

        // 获取连接
        DruidPooledConnection connection = druidDataSource.getConnection();

        // 数据库crud

        // 回收连接
        connection.close(); // 连接池提供的连接，close，就是回收连接!
    }

    /**
     * 通过读取外部配置文件的方法，实例化 druid 连接池对象
     */
    @Test
    public void useSoft() throws Exception {
        // 1.读取外部配置文件
        Properties properties = new Properties();

        // src下的文件，可以使用类加载器提供的方法
        InputStream ips = DruidUsePart.class.getClassLoader().getResourceAsStream("druid.properties");

        properties.load(ips);

        // 2. 使用连接池的工具类的工程模式，创建连接池
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        Connection connection = dataSource.getConnection();

        //数据库的crud

        //回收连接
        connection.close();
    }
}
