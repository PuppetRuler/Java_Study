package com.spring.iocxml.life;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * ClassName:MyBeanPost
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/25 16:36
 * @Version 1.0
 */
public class MyBeanPost implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("3 bean后置处理器，初始化之前执行");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("5 bean后置处理器，初始化之后执行");
        return bean;
    }
}
