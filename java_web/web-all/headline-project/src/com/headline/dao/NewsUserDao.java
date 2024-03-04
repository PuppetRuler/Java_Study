package com.headline.dao;

import com.headline.pojo.NewsUser;

/**
 * ClassName:NewsUserDao
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/19 21:05
 * @Version 1.0
 */
public interface NewsUserDao {

    NewsUser findByUserName(String username);

    NewsUser findById(Integer userId);

    Integer registUser(NewsUser user);
}
