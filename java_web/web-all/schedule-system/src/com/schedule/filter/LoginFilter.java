package com.schedule.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * ClassName:LoginFilter
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/19 15:06
 * @Version 1.0
 */
@WebFilter(urlPatterns={"/schedule/*","schedule.html"})
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 获得session对象
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse)servletResponse;
        HttpSession session = req.getSession();
        // 从session域中获得登录的用户对象
        Object sysUser = session.getAttribute("sysUser");
        // 判断用户对象是否为空
        if (sysUser==null){
            // 没登录 到login.html
            resp.sendRedirect("/login.html");
        }else {
            // 登录过 放行
            filterChain.doFilter(req, resp);
        }
    }
}
