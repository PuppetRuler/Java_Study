package com.schedule.dao;

import com.schedule.pojo.SysSchedule;

import java.util.List;

/**
 * ClassName:SysScheduleDao
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/13 16:09
 * @Version 1.0
 */
public interface SysScheduleDao {
    /**
     * 用于向数据中增加一条记录
     * @param schedule  日程数据以SysSchedule实体类对象形式入参
     * @return  返回影响数据库记录的行数，行数为0说明增加失败，行数大于0说明增加成功
     */
    int addSchedule(SysSchedule schedule);

    /**
     * 查询所有用户的所有日程
     * @return  将所有日程放入一个List<SysSchedule>集合中返回
     */
    List<SysSchedule> findAll();
}
