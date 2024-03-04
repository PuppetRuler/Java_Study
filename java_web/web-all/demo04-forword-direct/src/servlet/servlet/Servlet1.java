package servlet.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * ClassName:Servlet1
 * Description:
 *  1 重定向是通HttpServLetResponse.对象实现
 *  2 响应重定向是在服务端提示下的，客户端的行为
 *  3 客户端的地栏是变化的
 *  4 客户端至少发送了两次请求 客户端产生了多次请求
 *  5 请求产生了多次 后端就会有多个request对象 此时请求中的参数不能继续自动传递
 *  6 目标资源资源可以视图资源
 *  7 目标资源不可以是WEB-INF下的资源
 *  8 目标资源可以是外部资源
 * TODO:
 *  重点：同样能够实现页面跳转，优先使用响应重定向
 * @Author Sixty-three
 * @Create 2024/2/12 3:39
 * @Version 1.0
 */
@WebServlet("/servlet1")
public class Servlet1 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 接受用户请求
        System.out.println("Servlet1执行了");

        req.setCharacterEncoding("UTF-8"); // 设置解析请求体的字符集
        String username = req.getParameter("username");

        // 响应重定向 设置响应码为302 同时设置location响应头
        resp.sendRedirect("/servlet2");
    }
}
