package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * ClassName:ServletB
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/18 18:02
 * @Version 1.0
 */
@WebServlet("/servletB")
public class ServletB extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求中的cookie
        if (req.getCookies() == null) {
            for (Cookie cookie : req.getCookies()) {
                System.out.println(cookie.getName() + "=" + cookie.getValue());
            }
        }
    }
}
