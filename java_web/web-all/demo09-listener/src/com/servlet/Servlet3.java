package com.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * ClassName:Servlet1
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/19 14:16
 * @Version 1.0
 */
@WebServlet("servlet3")
public class Servlet3 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 删除数据
        ServletContext servletContext = req.getServletContext();
        servletContext.removeAttribute("username");
    }
}
