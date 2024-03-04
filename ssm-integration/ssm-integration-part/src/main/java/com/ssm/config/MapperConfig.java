package com.ssm.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.sql.DataSource;

/**
 * ClassName:MapperConfig
 * Description:
 *  方式一：保留xml配置文件
 *
 * TODO: 如果将dataSource和mybatis的组件配置到一起，出发@value注解不生效的问题
 *      原因： mybatis的组件优先加载，@value还没有读取！
 *      解决： 分开配置，写到不同的类即可！
 * @Author Sixty-three
 * @Create 2024/3/3 16:23
 * @Version 1.0
 */
@Configuration
public class MapperConfig {
    //sqlSessionFactory加入ioc容器
    //mybatis -> sqlSessionFactoryBean [ioc]-> getObject() -> sqlSessionFactory
    //方式1: 外部指定mybatis-config.xml [mybatis的配置 除了 连接池,mapper指定]
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource){

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

        // 指定配置文件等信息
        // 指定数据库连接池对象
        sqlSessionFactoryBean.setDataSource(dataSource);
        // 指定外部的mybatis配置文件
        // spring.core 包
        Resource resource = new ClassPathResource("mybatis-config.xml");
        sqlSessionFactoryBean.setConfigLocation(resource);

        return sqlSessionFactoryBean;
    }

    //mapper代理对象加入到ioc
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        // Mapper代理对象的factoryBean -> 指定一个包 -> mapper接口 -》sqlSessionFactory -> sqlSession -> getMapper -> mapper代理对象 -》 ioc
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.ssm.mapper"); //mapper接口和mapperxml所在的共同包
        return mapperScannerConfigurer;
    }

}
