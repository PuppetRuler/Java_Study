package com.spring.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ClassName:User
 * Description:
 *   读取配置的方式1: @Value
 *       直接可以在属性上添加即可
 *       @Value(key必须写全了)
 *       @value只能读取单个值
 *   批量配置读取:
 *      @ConfigurationProperties(prefix = "zwf.user") 通用的前缀
 *      实体类
 *        属性名 = 最后一个key的值
 *      优势1: 方便 不用一个一个读取
 *      优势2: 可以给集合类型赋值
 *
 * @Author Sixty-three
 * @Create 2024/3/4 0:44
 * @Version 1.0
 */
@Data
@Component //想注入 必须加到Ioc容器中
@ConfigurationProperties(prefix = "zwf.user")
public class User {

    private String username;
    private String password;
    private List<String> gfs;
}
