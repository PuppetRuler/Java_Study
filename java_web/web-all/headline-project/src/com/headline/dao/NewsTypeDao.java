package com.headline.dao;

import com.headline.pojo.NewsType;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

/**
 * ClassName:NewsTypeDao
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/19 21:05
 * @Version 1.0
 */
public interface NewsTypeDao {
    List<NewsType> findAllTypes(HttpServletRequest req, HttpServletResponse resp);
}
