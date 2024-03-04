package servlet.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

/**
 * ClassName:ServletConfig
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/11 21:07
 * @Version 1.0
 */
@WebServlet(
        urlPatterns = {"/servlet1"},
        initParams = {@WebInitParam(name = "keya", value = "valuea"),@WebInitParam(name = "keyb", value = "valueb")}
)
public class ServletConfig extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        jakarta.servlet.ServletConfig servletConfig = getServletConfig();
        // 获取初始化配置信息
        // 根据参数名获取参数值
        String keya = servletConfig.getInitParameter("keya");

        // 获取所有初始参数的名字
        // hasMoreElements()方法返回true表示有下一个元素，false表示没有下一个元素
        // nextElement()方法返回下一个元素，如果没有下一个元素，则返回null
        Enumeration<String> initParameterNames = servletConfig.getInitParameterNames();

        while (initParameterNames.hasMoreElements()) {
            String pname = initParameterNames.nextElement();
            System.out.println("pname = " + pname);
        }
    }
}
