package servlet.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

/**
 * ClassName:HttpServletRequestAPI
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/11 22:31
 * @Version 1.0
 */
@WebServlet("/httpServletRequestAPI")
public class HttpServletRequestAPI extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 行相关
        System.out.println(req.getMethod()); // 获取请求方式
        System.out.println(req.getScheme()); // 获取请求协议
        System.out.println(req.getProtocol()); // 获取请求协议及版本
        System.out.println(req.getRequestURI()); // 获取请求的uri 项目内的资源路径
        System.out.println(req.getRequestURL()); // 获取项目的url 项目内资源的完成的路径
        System.out.println(req.getLocalPort()); // 本应用容器的端口号 8080
        System.out.println(req.getServerPort()); // 客户端发请求时使用的端口号
        System.out.println(req.getRemotePort()); // 客户端软件的端口号

        // 头相关
        // 根据名字单独获取某个请求头
        String header = req.getHeader("User-Agent");
        System.out.println("header: " + header);
        // 获取本次请求中所有的请求头的名字
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            System.out.println("headerName: " + headerName);
        }

        // 获取请求参数
        // 根据参数名称获取耽搁参数值
        String username = req.getParameter("username");
        System.out.println(username);
        // 根据参数名获取多个参数值
        String[] hobbies = req.getParameterValues("hobby");
        System.out.println(Arrays.toString(hobbies));
        // 获取所有的参数名
        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String parameterName = parameterNames.nextElement();
            String[] parameterValues = req.getParameterValues(parameterName);
            if (parameterValues.length > 1) {
                System.out.println(parameterName + ": " + Arrays.toString(parameterValues));
            } else {
                System.out.println(parameterName + ": " + parameterValues[0]);
            }
        }
        // 返回所有参数的map集合     key=参数名 value=参数值
        Map<String, String[]> parameterMap = req.getParameterMap();
        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
            String pname = entry.getKey();
            String[] value = entry.getValue();
            if (value.length > 1) {
                System.out.println(pname + ": " + Arrays.toString(value));
            } else {
                System.out.println(pname + ": " + value[0]);
            }
        }

        /*
            以上API专门用于获取key=value形式的参数，无论这些参数是在uri后还是在请求体中
            获得请求体中的非键值对数据？
            获取一个从请求体中读取字符的字符输入流
                BufferedReader reader = req.getReader();  JS0N串
            获得一个从请求中读取二进制数据字节的输入流
                ServletInputStream inputstream = req.getInputStream(); 文件
         */

    }
}
