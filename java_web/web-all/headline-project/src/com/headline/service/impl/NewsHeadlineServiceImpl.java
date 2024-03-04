package com.headline.service.impl;

import com.headline.dao.NewsHeadLineDao;
import com.headline.dao.impl.NewsHeadlineDaoImpl;
import com.headline.pojo.HeadlineDetailVo;
import com.headline.pojo.HeadlinePageVo;
import com.headline.pojo.HeadlineQueryVo;
import com.headline.pojo.NewsHeadline;
import com.headline.service.NewsHeadlineService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName:NewsHeadlineServiceImpl
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/19 21:15
 * @Version 1.0
 */
public class NewsHeadlineServiceImpl implements NewsHeadlineService {
    private NewsHeadLineDao headlineDao = new NewsHeadlineDaoImpl();

    @Override
    public Map findNewsPage(HeadlineQueryVo headlineQueryVo) {
        int pageNum = headlineQueryVo.getPageNum();
        int pageSize = headlineQueryVo.getPageSize();
        List<HeadlinePageVo> pageData = headlineDao.findPageList(headlineQueryVo);
        int totalSize = headlineDao.findPageCount(headlineQueryVo);
        int totalPage = totalSize % pageSize == 0 ? totalSize / pageSize : totalSize / pageSize + 1;

        Map pageinfo = new HashMap();
        pageinfo.put("pageNum", pageNum);
        pageinfo.put("pageSize", pageSize);
        pageinfo.put("pageData", pageData);
        pageinfo.put("totalSize", totalSize);
        pageinfo.put("totalPage", totalPage);


        return pageinfo;
    }

    @Override
    public HeadlineDetailVo showHeadlineDetail(String hid) {
        // 修改该头条的浏览量 +1
        headlineDao.increPageViews(hid);
        return headlineDao.findHeadlineDetail(hid);
    }

    @Override
    public int addNewsHeadline(NewsHeadline newsHeadline) {
        return headlineDao.addNewsHeadline(newsHeadline);
    }

    @Override
    public NewsHeadline findHeadlineByHid(int hid) {
        return headlineDao.findHeadlineByHid(hid);
    }

    @Override
    public int updateNewsHeadline(NewsHeadline newsHeadline) {
        return headlineDao.updateNewsHeadline(newsHeadline);
    }

    @Override
    public int removeByHid(int i) {
        return headlineDao.removeByHid(i);
    }
}
