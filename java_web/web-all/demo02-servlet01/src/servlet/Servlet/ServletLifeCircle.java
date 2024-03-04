package servlet.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * ClassName:ServletLifeCircle
 * Description:
 * 1    实例化构造器
 * 2    初始化init
 * 3    接收请求处理请求服务service
 * 4    销毁 destory
 *
 * Servlet在Tomcat中是单例的
 * Servlet的成员变量在多个线程之中是共享的
 * 不建议在service方法中修改成员变量，在并发请求时，会引发线程安全问题
 * defualt-servlet 用于加载静态资资源的servlet,默认随服务启动，默认启动序号为1
 * @Author Sixty-three
 * @Create 2024/2/11 14:51
 * @Version 1.0
 */

@WebServlet(value="/servletLifeCircle",loadOnStartup = 6) // Tomcat抽离的公共web.xml里实例化序号从1-5，以后最好从6开始，避免冲突
public class ServletLifeCircle extends HttpServlet {

    public ServletLifeCircle() {
        System.out.println("构造器");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("初始化");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("服务");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    public void destroy() {
        System.out.println("销毁");
    }
}
