package com.servlet;

import com.listener.MySessionBindingListener;
import jakarta.servlet.ServletContext;
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
 * @Create 2024/2/19 14:16
 * @Version 1.0
 */
@WebServlet("servlet1")
public class Servlet1 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 向应用域中添加数据
        ServletContext servletContext = req.getServletContext();
        servletContext.setAttribute("username", "Sixty-three");

        HttpSession session = req.getSession();
        session.invalidate(); // 手动销毁session

        // 绑定监听器
        session.setAttribute("bindingListener",new MySessionBindingListener());
        // 解除绑定监听器
        session.removeAttribute("bindingListener");

        // 添加数据
        session.setAttribute("k1","v1");
        // 添加钝化活化监听器
        session.setAttribute("activationListener",new com.listener.ActivationListener());
    }
}
