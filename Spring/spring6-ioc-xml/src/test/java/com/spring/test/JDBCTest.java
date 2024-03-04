package com.spring.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

/**
 * ClassName:JDBCTest
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/25 15:47
 * @Version 1.0
 */
public class JDBCTest {

    @Test
    public void testDruid() throws Exception {
        Properties properties = new Properties();
        InputStream in = JDBCTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
        properties.load(in);
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
    }

    @Test
    public void testDruid2() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-jdbc");
        DruidDataSource dataSource = context.getBean("druidDataSource", DruidDataSource.class);
    }
}
