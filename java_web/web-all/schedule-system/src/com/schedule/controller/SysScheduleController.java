package com.schedule.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * ClassName:SysScheduleController
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/14 13:15
 * @Version 1.0
 */
@WebServlet("/schedule/*")
public class SysScheduleController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 判断请求方法
        String requestURI = req.getRequestURI();
        String[] split = requestURI.split("/");
        String methodName = split[split.length - 1];
        // 使用反射 通过方法名获取下面的方法
        Class aClass = methodName.getClass();
        try {
            Method declaredMethod = aClass.getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            // 暴力破解访问修饰符
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void find(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    protected void remove(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
