package com.spring.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * ClassName:logAdvice
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/3/4 12:23
 * @Version 1.0
 */
@Component
@Aspect
@Order(10)
public class LogAdvice {
    @Before("execution(* com..service.*.*(..))")
    public void before(JoinPoint point){
        String className = point.getTarget().getClass().getSimpleName();
        String methodName = point.getSignature().getName();
        System.out.println(className + methodName + ":aop开始执行");
    }
}
