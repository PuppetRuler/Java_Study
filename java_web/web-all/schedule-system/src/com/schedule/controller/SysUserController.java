package com.schedule.controller;

import com.schedule.pojo.SysUser;
import com.schedule.service.SysUserService;
import com.schedule.service.impl.SysUserServiceImpl;
import com.schedule.utils.MD5Util;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Objects;

/**
 * ClassName:SysScheduleController
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/14 13:15
 * @Version 1.0
 */
@WebServlet("/user/*")
public class SysUserController extends HttpServlet {
    private SysUserService userService = new SysUserServiceImpl();

    /**
     * 接受用户登录请求的业务处理方法
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 接收用户名和密码
        String username = req.getParameter("username");
        String userPwd = req.getParameter("userPwd");
        // 2. 调用服务层方法，根据用户名查询用户信息
        SysUser loginUser = userService.findByUsername(username);
        if(null == loginUser) {
            // 跳转到用户名有误提示页
            resp.sendRedirect("/loginUsernameError.html");
        } else if (!MD5Util.encrypt(userPwd).equals(loginUser.getUserPwd())) {
            // 3. 判断密码是否匹配
            resp.sendRedirect("/loginUserPwdError.html");
        }else {
            // 4. 跳转到登录页
            resp.sendRedirect("/loginSuccess.html");
            // 将数据放入session中
            HttpSession session = req.getSession();
            session.setAttribute("sysUser", loginUser);
        }
    }

    /**
     * 接受用户注册请求的业务处理方法
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 接收客户端提交的参数
        String username = req.getParameter("username");
        String userPwd = req.getParameter("userPwd");
        // 2. 调用服务层方法，完成注册功能
        SysUser user = new SysUser(null, username, userPwd); // 将参数封装进一个对象中
        int rows = userService.regist(user);
        // 3. 根据注册结果（成功失败）做页面跳转
        if (rows > 0) {
            resp.sendRedirect("/registSuccess.html");
        } else {
            resp.sendRedirect("/registFail.html");
        }
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        if (pathInfo.equals("/regist")) {
            regist(req, resp);
        } else if (pathInfo.equals("/login")) {
            login(req, resp);
        }
    }
}
