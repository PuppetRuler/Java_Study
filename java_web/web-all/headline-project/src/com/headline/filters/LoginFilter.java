package com.headline.filters;

import com.headline.common.Result;
import com.headline.common.ResultCodeEnum;
import com.headline.util.JWTUtil;
import com.headline.util.WebUtil;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * ClassName:LoginFilter
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/21 3:33
 * @Version 1.0
 */
@WebFilter("/headline/*")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String token = request.getHeader("token");
        if (token!= null &&!JWTUtil.isExpiration(token)) {
            filterChain.doFilter(servletRequest, servletResponse);
        }else {
            WebUtil.writeJson(response, Result.build(null,ResultCodeEnum.NOTLOGIN));
        }
    }
}
