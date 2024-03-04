package com.schedule.service;

import com.schedule.pojo.SysUser;

/**
 * ClassName:SysUserService
 * Description:
 *  该接口定义了以sys_user表格为核心的业务处理功能
 * @Author Sixty-three
 * @Create 2024/2/14 12:11
 * @Version 1.0
 */
public interface SysUserService {

    /**
     * 注册用户的方法
     * @param user User对象
     * @return  成功 1 ｜ 失败 0
     */
    int regist(SysUser user);

    /**
     * 根据用户名寻找用户对象
     * @param username
     * @return 找到返回用户对象 | 找不到返回null
     */
    SysUser findByUsername(String username);
}
