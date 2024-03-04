package com.schedule.dao;

import com.schedule.pojo.SysUser;

/**
 * ClassName:SysUserDao
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/13 16:01
 * @Version 1.0
 */
public interface SysUserDao {

    /**
     * 向数据库中增加一条用户记录的方法
     * @param user user对象
     * @return  成功 1 ｜ 失败 0
     */
    int addSysUser(SysUser user);

    /**
     * 根据用户名寻找用户对象
     * @param username
     * @return 找到返回用户对象 | 找不到返回null
     */
    SysUser findByUsername(String username);
}
