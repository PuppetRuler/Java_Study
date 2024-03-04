package com.spring.validator.three;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

/**
 * ClassName:ValidationConfig
 * Description:
 *      第一步 创建配置类，配置MethodValidationPostProcessor
 *
 * @Author Sixty-three
 * @Create 2024/2/27 16:05
 * @Version 1.0
 */
@Configuration
@ComponentScan("com.spring.validator.three")
public class ValidationConfig {
    @Bean
    public MethodValidationPostProcessor validationPostProcessor(){
        return new MethodValidationPostProcessor();
    }
}
