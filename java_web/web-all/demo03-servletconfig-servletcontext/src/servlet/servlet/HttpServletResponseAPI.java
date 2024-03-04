package servlet.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * ClassName:HttpServletResponseAPI
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/11 23:19
 * @Version 1.0
 */
@WebServlet("/httpServletResponseAPI")
public class HttpServletResponseAPI extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置响应行相关的API
        resp.setStatus(HttpServletResponse.SC_NOT_FOUND); // 响应404
        resp.setStatus(200);
        // 设置响应头相关的API
        // resp.setHeader("Content-Type", "text/html");
        resp.setContentType("text/html");

        String info = "<h1>Hello World!</h1>";
        // resp.setHeader("Content-Length", "1200");
        resp.setContentLength(info.getBytes().length);
        // 设置响应内容相关的API
        resp.getWriter().write(info);

        // 获得一个向响应体中输入二进制信息的字节输出流
        ServletOutputStream outputStream = resp.getOutputStream();
    }
}
