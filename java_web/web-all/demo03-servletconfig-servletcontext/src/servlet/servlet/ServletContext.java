package servlet.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

/**
 * ClassName:ServletContext
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/11 21:39
 * @Version 1.0
 */
public class ServletContext extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取ServletContext
        ServletConfig servletConfig = getServletConfig();
        jakarta.servlet.ServletContext servletContext = servletConfig.getServletContext();

        jakarta.servlet.ServletContext servletContext1 = req.getServletContext();

        jakarta.servlet.ServletContext servletContext2 = getServletContext();

        String encoding = servletContext1.getInitParameter("encoding");
        System.out.println("encoding = " + encoding);

        Enumeration<String> initParameterNames = servletContext1.getInitParameterNames();
        while (initParameterNames.hasMoreElements()) {
            String pname = initParameterNames.nextElement();
            System.out.println("pname = " + servletContext1.getInitParameter(pname));
        }
    }
}
