package com.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * ClassName:ServletA
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/19 1:31
 * @Version 1.0
 */
@WebServlet("/servletA")
public class ServletA extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 向请求域存放数据
        req.setAttribute("keya","valuea");

        // 向会话域存放数据
        HttpSession session = req.getSession();
        session.setAttribute("keyb","valueb");

        // 向应用域存放数据
        ServletContext appication = req.getServletContext();
        appication.setAttribute("application","applicationValue");

        // 获取请求域中的数据
        String keya = (String) req.getAttribute("keya");
        System.out.println("请求域数据："+keya);

        // 请求转发
        req.getRequestDispatcher("/servletB").forward(req,resp);
    }
}
