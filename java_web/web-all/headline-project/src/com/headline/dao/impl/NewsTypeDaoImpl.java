package com.headline.dao.impl;

import com.headline.dao.BaseDao;
import com.headline.dao.NewsTypeDao;
import com.headline.pojo.NewsType;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

/**
 * ClassName:NewsTypeDaoImpl
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/19 21:11
 * @Version 1.0
 */
public class NewsTypeDaoImpl extends BaseDao implements NewsTypeDao {
    @Override
    public List<NewsType> findAllTypes(HttpServletRequest req, HttpServletResponse resp) {
        String sql = """
                    select *
                    from news_type
                    """;
        List<NewsType> list = baseQuery(NewsType.class, sql);

        return list!= null && list.size() > 0? list : null;
    }
}
