package com.schedule.service.impl;

import com.schedule.dao.SysUserDao;
import com.schedule.dao.impl.SysUserDaoImpl;
import com.schedule.pojo.SysUser;
import com.schedule.service.SysUserService;
import com.schedule.utils.MD5Util;

/**
 * ClassName:SysUserServiceImpl
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/14 12:13
 * @Version 1.0
 */
public class SysUserServiceImpl implements SysUserService {
    private SysUserDao userDao = new SysUserDaoImpl();

    @Override
    public int regist(SysUser user) {
        // 将用户的明文密码转换成密文密码
        user.setUserPwd(MD5Util.encrypt(user.getUserPwd()));
        // 调用DAO层的方法 将user信息存入数据库
        return userDao.addSysUser(user);
    }

    @Override
    public SysUser findByUsername(String username) {
        return userDao.findByUsername(username);
    }
}
