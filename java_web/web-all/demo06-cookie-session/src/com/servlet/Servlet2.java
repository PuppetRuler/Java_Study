package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * ClassName:Servlet2
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/19 0:07
 * @Version 1.0
 */
@WebServlet("/servlet2")
public class Servlet2 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取session对象
        HttpSession session = req.getSession();

        // session.setMaxInactiveInterval(30); // 设置session超时时间

        System.out.println(session.getId());
        System.out.println(session.isNew());
        // 读取用户名
        String username = (String)session.getAttribute("username");
        System.out.println("servlet2:username=" + username);

    }
}
