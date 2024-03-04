package com.headline.dao;

import com.headline.pojo.HeadlineDetailVo;
import com.headline.pojo.HeadlinePageVo;
import com.headline.pojo.HeadlineQueryVo;
import com.headline.pojo.NewsHeadline;

import java.util.List;

/**
 * ClassName:NewsHeadLineDao
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/19 21:04
 * @Version 1.0
 */
public interface NewsHeadLineDao {

    /**
     *
     * @param headlineQueryVo
     * @return
     */
    List<HeadlinePageVo> findPageList(HeadlineQueryVo headlineQueryVo);

    /**
     *
     * @param headlineQueryVo
     * @return
     */
    int findPageCount(HeadlineQueryVo headlineQueryVo);

    /**
     *
     * @param hid
     * @return
     */
    int increPageViews(String hid);

    /**
     *
     * @param hid
     * @return
     */
    HeadlineDetailVo findHeadlineDetail(String hid);

    /**
     *
     * @param newsHeadline
     * @return
     */
    int addNewsHeadline(NewsHeadline newsHeadline);

    /**
     *
     * @param hid
     * @return
     */
    NewsHeadline findHeadlineByHid(int hid);

    /**
     *
     * @param newsHeadline
     * @return
     */
    int updateNewsHeadline(NewsHeadline newsHeadline);

    int removeByHid(int i);
}
