package com.headline.service;

import com.headline.pojo.NewsUser;

/**
 * ClassName:NewsHeadlineService
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/19 21:14
 * @Version 1.0
 */
public interface NewsUserService {

    /**
     * 根据输入的用户名返回用户的对象
     * @param username
     * @return  如果有返回 NewsUser对象 否则为null
     */
    NewsUser findByUserName(String username);

    /**
     *
     * @param userId
     * @return
     */
    NewsUser findById(Integer userId);

    /**
     *
     * @param user
     * @return
     */
    Integer registUser(NewsUser user);
}
