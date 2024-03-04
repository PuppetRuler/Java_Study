package com.headline.controller;

/**
 * ClassName:PortalController
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/19 21:20
 * @Version 1.0
 */

import com.headline.common.Result;
import com.headline.pojo.HeadlineDetailVo;
import com.headline.pojo.HeadlineQueryVo;
import com.headline.pojo.NewsType;
import com.headline.service.NewsHeadlineService;
import com.headline.service.NewsTypeService;
import com.headline.service.impl.NewsHeadlineServiceImpl;
import com.headline.service.impl.NewsTypeServiceImpl;
import com.headline.util.WebUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 门户 控制器
 * 那些不需要登录，不需要做增删改的门户页的请求都放在这里
 */
@WebServlet("/portal/*")
public class PortalController extends BaseController {

    private NewsTypeService newsTypeService = new NewsTypeServiceImpl();
    private NewsHeadlineService newsHeadlineService = new NewsHeadlineServiceImpl();

    /**
     * 分页查询头条信息的接口实现
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void findNewsPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 接收请求中的参数
        HeadlineQueryVo headlineQueryVo = WebUtil.readJson(req, HeadlineQueryVo.class);
        // 将参数传递给服务层进行分页查询
        Map info = newsHeadlineService.findNewsPage(headlineQueryVo);
        HashMap map = new HashMap();
        map.put("pageInfo", info);
        Result result = Result.ok(map);

        // 将分页查询的结果转换成json 响应给客户端
        WebUtil.writeJson(resp,result);

    }

    /**
     * 查询所有头条类型的业务实现接口
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void findAllTypes(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 查询所有的新闻类型，装入Result响应给客户端
        List<NewsType> types = newsTypeService.findAllTypes(req, resp);
        Result result = Result.ok(types);
        WebUtil.writeJson(resp,result);
    }

    /**
     * 根据头条id查询内容业务接口
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void showHeadlineDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 接收要查询头条的id
        String hid = req.getParameter("hid");
        // 调用服务层完成查询业务
        HeadlineDetailVo headlineDetailVo = newsHeadlineService.showHeadlineDetail(hid);
        // 将要查询的信息响应给客户端
        Map map = new HashMap();
        map.put("headline", headlineDetailVo);
        Result result = Result.ok(map);
        WebUtil.writeJson(resp,result);
    }
}
