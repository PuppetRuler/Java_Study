package servlet.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * ClassName:ServletA
 * Description:
 *  1 请求转发是通HttpServletRequest对象实现的
 *  2 请求转发是服务器内部行为，对客户端是屏蔽的
 *  3 客户端只产生了一次请求服务端只产生了一对 request response 对象
 *  4 客户端的地址栏是不变的
 *  5 请求的参数是可以继续传递的
 *  6 目标资源可以是servlet动态资源也可以是html静态资源
 *  7 目标资源可以是WEB-INF下的受保护的资源 该方式也是WEB-INF下的资源的唯一访问方式
 *  8 目标资源不可以是外部的资源
 * @Author Sixty-three
 * @Create 2024/2/11 23:58
 * @Version 1.0
 */
@WebServlet("/servletA")
public class ServletA extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("servletA执行了");

        // 请求转发给ServletB
        // 获取请求转发器
        RequestDispatcher servletB = req.getRequestDispatcher("servletB");
        // 让请求转发器作出转发动作
        servletB.forward(req, resp);
    }
}
