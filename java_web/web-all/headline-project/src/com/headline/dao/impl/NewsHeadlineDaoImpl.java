package com.headline.dao.impl;

import com.headline.dao.BaseDao;
import com.headline.dao.NewsHeadLineDao;
import com.headline.pojo.HeadlineDetailVo;
import com.headline.pojo.HeadlinePageVo;
import com.headline.pojo.HeadlineQueryVo;
import com.headline.pojo.NewsHeadline;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:NewsHeadlineDaoImpl
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/19 21:09
 * @Version 1.0
 */
public class NewsHeadlineDaoImpl extends BaseDao implements NewsHeadLineDao {
    @Override
    public List<HeadlinePageVo> findPageList(HeadlineQueryVo headlineQueryVo) {
        List params = new ArrayList();
        String sql = """
                select
                hid,title,type,page_views pageViews,TIMESTAMPDIFF(HOUR,create_time,now()) pastHours,publisher
                from news_headline
                where is_deleted=0
                """;
        if (headlineQueryVo.getType() != null && headlineQueryVo.getType() != 0) {
            sql = sql.concat(" and type =? ");
            params.add(headlineQueryVo.getType());
        }
        if (headlineQueryVo.getKeyWords() != null && !"".equals(headlineQueryVo)) {
            sql = sql.concat(" and title like ? ");
            params.add("%" + headlineQueryVo.getKeyWords() + "%"); // 这里的百分号左右都不能有空格!!!!!!!!
        }
        sql = sql.concat(" order by pastHours ASC,pageViews DESC ");
        sql = sql.concat(" limit ? , ? ");
        params.add((headlineQueryVo.getPageNum() - 1) * headlineQueryVo.getPageSize());
        params.add(headlineQueryVo.getPageSize());

        List<HeadlinePageVo> list = baseQuery(HeadlinePageVo.class, sql, params.toArray());

        return list;
    }

    @Override
    public int findPageCount(HeadlineQueryVo headlineQueryVo) {
        List params = new ArrayList();
        String sql = """
                select
                count(1)
                from news_headline
                where is_deleted=0
                """;
        if (headlineQueryVo.getType() != null) {
            sql = sql.concat(" and type =? ");
            params.add(headlineQueryVo.getType());
        }
        if (headlineQueryVo.getKeyWords() != null && !"".equals(headlineQueryVo)) {
            sql = sql.concat(" and title like ? ");
            params.add("%" + headlineQueryVo.getKeyWords() + "%");
        }

        return baseQueryObject(Long.class, sql, params.toArray()).intValue();
    }

    @Override
    public int increPageViews(String hid) {
        String sql = """
                    update news_headline
                    set page_views = page_views + 1
                    where hid =?
                    """;
        return baseUpdate(sql,hid);
    }

    @Override
    public HeadlineDetailVo findHeadlineDetail(String hid) {
        String sql = """
                    select
                        h.hid hid,
                        h.title title,
                        h.article article,
                        h.type type,
                        t.tname typeName,
                        h.page_views pageViews,
                        TIMESTAMPDIFF(HOUR,h.create_time,now())pastHours,
                        h.publisher publisher,
                        u.nick_name author
                    from
                        news_headline h
                    left join
                        news_type t
                    on
                        h.type = t.tid
                    left join
                        news_user u
                    on
                        h.publisher = u.uid
                    where
                        h.hid =?
                    """;

        List<HeadlineDetailVo> list = baseQuery(HeadlineDetailVo.class, sql, hid);
        return list != null && list.size() > 0 ? list.get(0):null;
    }

    @Override
    public int addNewsHeadline(NewsHeadline newsHeadline) {
        String sql = """
                    insert into news_headline
                    values(DEFAULT,?,?,?,?,0,now(),now(),0)
                    """;
        return baseUpdate(sql,newsHeadline.getTitle(),newsHeadline.getArticle(),
                newsHeadline.getType(),newsHeadline.getPublisher());
    }

    @Override
    public NewsHeadline findHeadlineByHid(int hid) {
        String sql = """
                    select
                        hid,
                        title,
                        article,
                        type,
                        publisher,
                        page_views pageViews,
                        create_time createTime,
                        update_time updateTime,
                        is_deleted isDeleted
                    from
                        news_headline
                    where
                        hid = ?
                    """;
        List<NewsHeadline> list = baseQuery(NewsHeadline.class, sql, hid);
        return list != null && list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public int updateNewsHeadline(NewsHeadline newsHeadline) {
        String sql = """
                    update
                        news_headline
                    set
                        title=?,
                        article=?,
                        type=?,
                        update_time=now()
                    where
                        hid=?
                    """;
        int i = baseUpdate(sql, newsHeadline.getTitle(), newsHeadline.getArticle(),
                newsHeadline.getType(), newsHeadline.getHid());
        return i;
    }

    @Override
    public int removeByHid(int i) {
        String sql = """
                    update
                        news_headline
                    set
                        is_deleted=1
                    where
                        hid=?
                    """;
        return baseUpdate(sql,i);
    }
}
