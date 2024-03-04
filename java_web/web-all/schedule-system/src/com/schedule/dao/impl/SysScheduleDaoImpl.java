package com.schedule.dao.impl;

import com.schedule.dao.BaseDao;
import com.schedule.dao.SysScheduleDao;
import com.schedule.pojo.SysSchedule;

import java.util.List;

/**
 * ClassName:SysScheduleDaoImpl
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/13 16:10
 * @Version 1.0
 */
public class SysScheduleDaoImpl extends BaseDao implements SysScheduleDao {
    @Override
    public int addSchedule(SysSchedule schedule) {
        String sql = "insert into sys_schedule values(DEFAULT,?,?,?)";
        int rows = baseUpdate(sql,schedule.getUid(),schedule.getTitle(),schedule.getCompleted());
        return rows;
    }

    @Override
    public List<SysSchedule> findAll() {
        String sql = "select * from sys_schedule";
        List<SysSchedule> list = baseQuery(SysSchedule.class,sql);
        return list;
    }
}
