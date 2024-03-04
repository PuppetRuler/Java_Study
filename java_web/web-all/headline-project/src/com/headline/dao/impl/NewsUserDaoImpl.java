package com.headline.dao.impl;

import com.headline.dao.BaseDao;
import com.headline.dao.NewsUserDao;
import com.headline.pojo.NewsUser;

import java.util.List;

/**
 * ClassName:NewsUserDaoImpl
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/19 21:12
 * @Version 1.0
 */
public class NewsUserDaoImpl extends BaseDao implements NewsUserDao {
    @Override
    public NewsUser findByUserName(String username) {
        String sql = """
                select uid,username,user_pwd userPwd,nick_name nickName
                from news_user
                where username =?
                """;
        List<NewsUser> list = baseQuery(NewsUser.class, sql, username);

        return list != null && list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public NewsUser findById(Integer userId) {
        String sql = """
                select uid,username,user_pwd userPwd,nick_name nickName
                from news_user
                where uid =?
                """;
        List<NewsUser> list = baseQuery(NewsUser.class, sql, userId);

        return list != null && list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public Integer registUser(NewsUser user) {
        String sql = """
                insert into news_user(username,user_pwd,nick_name)
                values(?,?,?)
                """;
        return baseUpdate(sql,user.getUsername(), user.getUserPwd(), user.getNickName());
    }
}
