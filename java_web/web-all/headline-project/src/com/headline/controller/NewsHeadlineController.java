package com.headline.controller;

import com.headline.common.Result;
import com.headline.pojo.NewsHeadline;
import com.headline.service.NewsHeadlineService;
import com.headline.service.impl.NewsHeadlineServiceImpl;
import com.headline.util.JWTUtil;
import com.headline.util.WebUtil;
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
@WebServlet("/headline/*")
public class NewsHeadlineController extends BaseController {

    private NewsHeadlineService newsHeadlineService = new NewsHeadlineServiceImpl();

    /**
     * 发布头条的业务实现
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void publish(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取JSON
        NewsHeadline newsHeadline = WebUtil.readJson(req, NewsHeadline.class);
        // 获取发布者
        String token = req.getHeader("token");
        newsHeadline.setPublisher(JWTUtil.getUserId(token).intValue());
        // 存入数据库
        newsHeadlineService.addNewsHeadline(newsHeadline);

        WebUtil.writeJson(resp, Result.ok(null));
    }

    /**
     * 修改头条回显的业务接口
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void findHeadlineByHid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int hid = Integer.parseInt(req.getParameter("hid"));
        NewsHeadline newsHeadline = newsHeadlineService.findHeadlineByHid(hid);
        Map map = new HashMap();
        map.put("headline", newsHeadline);
        WebUtil.writeJson(resp,Result.ok(map));
    }

    /**
     * 实现修改业务的接口
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NewsHeadline newsHeadline = WebUtil.readJson(req, NewsHeadline.class);
        newsHeadlineService.updateNewsHeadline(newsHeadline);
        WebUtil.writeJson(resp, Result.ok(null));
    }

    /**
     * 实现删除业务的接口
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void removeByHid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String hid = req.getParameter("hid");
        newsHeadlineService.removeByHid(Integer.parseInt(hid));
        WebUtil.writeJson(resp, Result.ok(null));
    }
}
