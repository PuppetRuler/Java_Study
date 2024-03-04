package com.headline.service.impl;

import com.headline.dao.NewsTypeDao;
import com.headline.dao.impl.NewsTypeDaoImpl;
import com.headline.pojo.NewsType;
import com.headline.service.NewsTypeService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

/**
 * ClassName:NewsHeadlineServiceImpl
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/19 21:15
 * @Version 1.0
 */
public class NewsTypeServiceImpl implements NewsTypeService {
    private NewsTypeDao newsTypedao = new NewsTypeDaoImpl();
    @Override
    public List<NewsType> findAllTypes(HttpServletRequest req, HttpServletResponse resp) {
        return newsTypedao.findAllTypes(req, resp);
    }
}
