package com.springmvc.error;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * ClassName:GlobalExceptionHandler
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/3/3 0:16
 * @Version 1.0
 */
//全局异常发生，会走此类写的handler!
//@ControllerAdvice  //可以返回逻辑视图 转发和重定向的！
@RestControllerAdvice //@ResponseBody直接返回json字符串
public class GlobalExceptionHandler {
    //发生异常 -》ControlLerAdvice 注解的类型 -》 @ExceptionHandler(指定的异常)->handler
    //指定的异常可以精准查找，或者查找父异常！

    @ExceptionHandler(NullPointerException.class)
    public Object NullPointerExceptionHandler(NullPointerException e){
        // 自定义处理的异常
        String message = e.getMessage();
        System.out.println("message = " + message);

        return  message;
    }

    @ExceptionHandler(Exception.class)
    public Object ExceptionHandler(Exception e){
        // 自定义处理的异常
        String message = e.getMessage();
        System.out.println("message = " + message);

        return  message;
    }
}
