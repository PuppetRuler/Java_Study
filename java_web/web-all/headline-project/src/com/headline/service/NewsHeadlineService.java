package com.headline.service;

import com.headline.pojo.HeadlineDetailVo;
import com.headline.pojo.HeadlineQueryVo;
import com.headline.pojo.NewsHeadline;

import java.util.Map;

/**
 * ClassName:NewsHeadlineService
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/19 21:14
 * @Version 1.0
 */
public interface NewsHeadlineService {
    /**
     *
     * @param headlineQueryVo
     * @return
     */
    Map findNewsPage(HeadlineQueryVo headlineQueryVo);

    HeadlineDetailVo showHeadlineDetail(String hid);

    int addNewsHeadline(NewsHeadline newsHeadline);

    NewsHeadline findHeadlineByHid(int hid);

    int updateNewsHeadline(NewsHeadline newsHeadline);

    int removeByHid(int i);
}
