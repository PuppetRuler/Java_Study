package com.spring.validator.two;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/**
 * ClassName:ValidatorConfig
 * Description:
 *  第一步 创建配置类，配置LocalValidatorFactoryBean
 * @Author Sixty-three
 * @Create 2024/2/27 15:44
 * @Version 1.0
 */
@Configuration
@ComponentScan("com.spring.validator.two")
public class ValidatorConfig {

    @Bean
    public LocalValidatorFactoryBean validatorFactoryBean() {
        return new LocalValidatorFactoryBean();
    }
}
