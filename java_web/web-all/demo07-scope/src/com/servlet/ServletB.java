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
@WebServlet("/servletB")
public class ServletB extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求域中的数据
        String keya = (String) req.getAttribute("keya");
        System.out.println("请求域数据："+keya);

        // 获取会话域中的数据
        HttpSession session = req.getSession();
        String keyb = (String) session.getAttribute("keyb");
        System.out.println("会话域数据："+keyb);

        // 获取应用域中的数据
        ServletContext appication = req.getServletContext();
        String application = (String) appication.getAttribute("application");
        System.out.println("应用域数据："+application);
    }
}
