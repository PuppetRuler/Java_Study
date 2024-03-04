package servlet.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * ClassName:ArributeScope1
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/11 22:21
 * @Version 1.0
 */
@WebServlet("/s1")
public class ArributeScope1 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // void setAttribute(String key,Object value);  向域中存储/修改数据
        // Object getAttribute(String key);             获得域中的数据
        // void removeAttribute(String key);            移除域中的数据
        ServletContext servletContext = getServletContext();
        servletContext.setAttribute("ka","va");
    }
}
