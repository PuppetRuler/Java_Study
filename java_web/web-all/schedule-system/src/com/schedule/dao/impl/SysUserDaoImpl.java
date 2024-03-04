package com.schedule.dao.impl;

import com.schedule.dao.BaseDao;
import com.schedule.dao.SysUserDao;
import com.schedule.pojo.SysUser;

import java.util.List;

/**
 * ClassName:SysUserDaoImpl
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/13 16:10
 * @Version 1.0
 */
public class SysUserDaoImpl extends BaseDao implements SysUserDao {

    @Override
    public int addSysUser(SysUser user) {
        String sql = "insert into sys_user values(DEFAULT,?,?)";
        return baseUpdate(sql,user.getUsername(),user.getUserPwd());
    }

    @Override
    public SysUser findByUsername(String username) {
        String sql = "select uid,username,user_pwd userPwd from sys_user where username =?";
        List<SysUser> list = baseQuery(SysUser.class, sql, username);
        return list != null&&list.size() > 0 ? list.get(0):null;
    }
}
