package com.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ClassName:LoggingFilter
 * Description:
 *  1 实现Filter接口
 *  2 重写过滤方法
 *  3 配置过滤器
 *      web,xml
 *      注解
 * @Author Sixty-three
 * @Create 2024/2/19 2:17
 * @Version 1.0
 */
public class LoggingFilter implements Filter {

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 过滤请求的和响应的方法
     *  1   请求到达目标资源之前，先经过该方法
     *  2   该方法有能力控制请求是否继续向后到达目标资源 可以在该方法内直接向客户端做响应处理
     *  3   请求到达目标资源后，响应之前，还会经过该方法
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        /*
        1   清求到达目标资源之前的功能代码
                判断是否登录
                校验权限是否满足
                ......
        2   放行代码

        3   响应之前    HttpServLetResponse转换为响应报文之前的功能代码
        * */

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // 到达目标资源之前 打印日志 yyyy-MM-dd HH:mm:ss **被访问了
        String uri = request.getRequestURI();
        String dateformat = dateFormat.format(new Date());
        System.out.println(uri+"在"+dateformat+"被访问了");

        long t1 = System.currentTimeMillis();
        // 放行
        filterChain.doFilter(servletRequest, servletResponse);
        long t2 = System.currentTimeMillis();

        // 响应之前的功能代码
        System.out.println(uri+"资源在"+dateformat+"的请求延时:"+(t2-t1)+"毫秒");
    }
}
