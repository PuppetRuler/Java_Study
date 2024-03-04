package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * ClassName:ServletA
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/12 13:39
 * @Version 1.0
 */
@WebServlet("/servletA")
public class ServletA extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 重定向到ServletB
        /*
        * 1. 相对路径写法
        *   和前端的相对路径规则一致
        * 2. 绝对路径写法
        *   http://localhost:8080
        * */
        // resp.sendRedirect("/servletB");

        // resp.sendRedirect(req.getServletContext().getContextPath()+"/servletB");

        // 请求转发到ServletB
        /*
        * 1. 相对路径写法 一致
        *
        * 2. 绝对路径
        *       请求转发的绝对路径是不需要添加项目上下文
        *       请求转发的/ 代表的路径是     http://localhost:8080/d05/
        * */
        req.getRequestDispatcher("/servletB").forward(req,resp);
    }
}
