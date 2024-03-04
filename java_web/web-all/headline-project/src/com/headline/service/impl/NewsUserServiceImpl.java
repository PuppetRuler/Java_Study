package com.headline.service.impl;

import com.headline.dao.NewsUserDao;
import com.headline.dao.impl.NewsUserDaoImpl;
import com.headline.pojo.NewsUser;
import com.headline.service.NewsUserService;
import com.headline.util.MD5Util;

/**
 * ClassName:NewsUserServiceImpl
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/19 21:15
 * @Version 1.0
 */
public class NewsUserServiceImpl implements NewsUserService {
    private NewsUserDao newsUserDao = new NewsUserDaoImpl();
    @Override
    public NewsUser findByUserName(String username) {
        return newsUserDao.findByUserName(username);
    }

    @Override
    public NewsUser findById(Integer userId) {
        return newsUserDao.findById(userId);
    }

    @Override
    public Integer registUser(NewsUser user) {
        // 将明文密码转换成密文密码
        user.setUserPwd(MD5Util.encrypt(user.getUserPwd()));
        return newsUserDao.registUser(user);
    }
}
