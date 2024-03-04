package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * ClassName:ServletA
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/18 17:59
 * @Version 1.0
 */
@WebServlet("/servletA")
public class ServletA extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 创建cookie
        Cookie cookiea = new Cookie("keya", "valuea");
        // cookie的持久化设置
        cookiea.setMaxAge(60*5); // 单位：s
        // cookie提交的path设置
        cookiea.setPath("/servletB");
        Cookie cookieb = new Cookie("keyb", "valueb");
        // 将cookie放入resp
        resp.addCookie(cookiea);
        resp.addCookie(cookieb);
    }
}
