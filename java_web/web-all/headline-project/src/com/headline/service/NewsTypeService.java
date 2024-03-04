package com.headline.service;

import com.headline.pojo.NewsType;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

/**
 * ClassName:NewsHeadlineService
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/19 21:14
 * @Version 1.0
 */
public interface NewsTypeService {
    List<NewsType> findAllTypes(HttpServletRequest req, HttpServletResponse resp);
}
