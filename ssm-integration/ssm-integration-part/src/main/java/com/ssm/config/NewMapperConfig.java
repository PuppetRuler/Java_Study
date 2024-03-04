package com.ssm.config;

import com.alibaba.druid.support.logging.SLF4JImpl;
import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.logging.slf4j.Slf4jImpl;
import org.apache.ibatis.session.AutoMappingBehavior;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * ClassName:MapperConfig
 * Description:   方式二：不保留xml配置文件
 * @Author Sixty-three
 * @Create 2024/3/3 16:23
 * @Version 1.0
 */
@Configuration
public class NewMapperConfig {
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource){

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

        // 指定配置文件等信息
        // 指定数据库连接池对象
        sqlSessionFactoryBean.setDataSource(dataSource);
        // 指定mybatis配置文件的功能，以代码的形式
        org.apache.ibatis.session.Configuration configuration =
                new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        configuration.setLogImpl(Slf4jImpl.class);
        configuration.setAutoMappingBehavior(AutoMappingBehavior.FULL);

        //org.apache.ibatis.session.Configuration // 存储setting的配置文件
        sqlSessionFactoryBean.setConfiguration(configuration);

        // 别名设置
        sqlSessionFactoryBean.setTypeAliasesPackage("com.ssm.pojo");

        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("helperDialect","mysql");
        pageInterceptor.setProperties(properties);
        sqlSessionFactoryBean.addPlugins(pageInterceptor);

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
