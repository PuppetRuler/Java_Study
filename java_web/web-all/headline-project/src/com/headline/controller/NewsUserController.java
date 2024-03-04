package com.headline.controller;

import com.headline.common.ResultCodeEnum;
import com.headline.pojo.NewsUser;
import com.headline.service.NewsUserService;
import com.headline.service.impl.NewsUserServiceImpl;
import com.headline.util.JWTUtil;
import com.headline.util.MD5Util;
import com.headline.util.WebUtil;
import com.headline.common.Result;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName:NewsHeadlineController
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/19 21:17
 * @Version 1.0
 */
@WebServlet("/user/*")
public class NewsUserController extends BaseController {
    private NewsUserService userService = new NewsUserServiceImpl();

    /**
     * 处理登录表单提交的业务接口的实现
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 接收用户名和密码
        /*
        * username
        * userPwd
        * */
        NewsUser paramUser = WebUtil.readJson(req, NewsUser.class);

        // 调用服务层方法 实现登录
        NewsUser loginUser = userService.findByUserName(paramUser.getUsername());
        Result result = null;
        if(null != loginUser) {
            if(MD5Util.encrypt(paramUser.getUserPwd()).equalsIgnoreCase(loginUser.getUserPwd())){
                Map data = new HashMap();
                data.put("token", JWTUtil.createToken(loginUser.getUid().longValue()));
                result = Result.ok(data);
            }else {
                result = Result.build(null, ResultCodeEnum.PASSWORD_ERROR);
            }
        } else {
            result = Result.build(null, ResultCodeEnum.USERNAME_ERROR);
        }

        // 向客户端响应登录验证信息
        WebUtil.writeJson(resp,result);
    }

    /**
     * 处理token获取用户信息的接口业务实现
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void getUserInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求中的token
        String token = req.getHeader("token");

        Result result = Result.build(null, ResultCodeEnum.NOTLOGIN);

        // 校验token
        if(null != token && !"".equals(token)) {
            if(!JWTUtil.isExpiration(token)) {
                Integer userId = JWTUtil.getUserId(token).intValue();
                NewsUser user = userService.findById(userId);
                if(user != null) {
                    // 通过校验 查询用户信息放入Result
                    Map data = new HashMap();
                    user.setUserPwd("");
                    data.put("loginUser", user);

                    result = Result.ok(data);
                }
            }
        }

        // 未通过校验 响应Result code 504
        WebUtil.writeJson(resp,result);

    }

    /**
     * 校验用户名是否被占用的业务接口实现
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void checkUserName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求中的用户名
        String username = req.getParameter("username");
        // 校验用户名是否被占用 找到了响应505 找不到响应200
        Result result = Result.ok(null);

        NewsUser user = userService.findByUserName(username);
        if(user != null){
            result = Result.build(null,ResultCodeEnum.USERNAME_USED);
        }

        WebUtil.writeJson(resp,result);
    }

    /**
     * 完成注册的业务接口
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 读取JSON信息
        NewsUser user = WebUtil.readJson(req, NewsUser.class);

        // 调用服务层代码实现注册
        Integer rows = userService.registUser(user);

        Result result = Result.ok(null);
        // 判断注册是否成功
        if(rows == 0){
            result = Result.build(null,ResultCodeEnum.USERNAME_USED);
        }

        WebUtil.writeJson(resp, result);
    }

    /**
     * 前端用于检验token是否失效的接口
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void checkLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = req.getHeader("token");

        Result result = Result.build(null,ResultCodeEnum.NOTLOGIN);
        if(token != null ){
            if(!JWTUtil.isExpiration(token)){
                result = Result.ok(null);
            }
        }
        WebUtil.writeJson(resp,result);
    }
}
