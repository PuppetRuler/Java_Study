package servlet.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * ClassName:UserServlet
 * Description:
 *      1. 创建javaweb项目，同时将Tomcat添加为当前项目的依赖
 *      2. 重写service方法  service(HttpServletRequest req, HttpServletResponse resp)
 *      3. 重写service方法，service(HttpServletResponse resp, HttpServletResponse resp)
 *      4. 在web.xml中，配置Servlet对应的请求映射路径
 *
 *      1 servlet-api.jar导入问题
 *          servlet-api编码的时候需要，运行的时候在服务器的环境中，由服务软件(Tomcat)提供
 *          因此，我们的JAVAWEB项目中在打包/构建的时候是无需携带servlet-api的jar包
 *      2    Content-Type响应头的问题
 * @Author Sixty-three
 * @Create 2024/2/10 16:45
 * @Version 1.0
 */
public class UserServlet extends HttpServlet {
    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 从request 对象中获取请求中的任何信息(username参数)
        String username = req.getParameter("username");// 根据参数名获取参数值 无论参数是在url?后还是在请求体中

        // 2. 处理业务的代码
        String info = "YES";
        if("atguigu".equals(username)) {
            info = "NO";
        }
        // 3. 将要响应的数据放入response
        // 应该设置Content-Type响应头
        resp.setHeader("Content-Type", "text/html");

        PrintWriter writer = resp.getWriter(); // 该方法返回的是一个向响应体中打印字符串的打印流
        writer.write(info);
    }
}

















