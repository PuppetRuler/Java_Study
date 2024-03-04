package com.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

/**
 * ClassName:Filter1
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/19 13:55
 * @Version 1.0
 */
@WebFilter("/*")
public class Filter2 implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤器2过滤前");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("过滤器2响应前");
    }
}
