package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * ClassName:Servlet1
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/18 18:18
 * @Version 1.0
 */
@WebServlet("/servlet1")
public class Servlet1 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求中的username
        String username = req.getParameter("username");
        // 获取session对象
        HttpSession session = req.getSession();
        // 判断请求中有没有一个特殊的cookie JSESSIONID
            // 1 有
                // 找到了
                    // 返回之前的session
                // 没找到
                    // 创建一个新的session,并且向response对象中存放一个JSESSIONID的cookie
            // 2 没有
                // 创建一个新的session,并且向response对象中存放一个JSESSIONID的cookie
        System.out.println(session.getId());
        System.out.println(session.isNew());

        // 将username存入session
        session.setAttribute("username",username);

        // 响应客户端
        resp.setHeader("Content-Type", "text/html;charset=UTF-8");
        resp.getWriter().write("成功");
    }
}
