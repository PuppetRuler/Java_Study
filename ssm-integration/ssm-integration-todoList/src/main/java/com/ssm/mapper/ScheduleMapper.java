package com.ssm.mapper;

import com.ssm.pojo.Schedule;
import com.ssm.utils.R;

import java.util.List;

/**
 * ClassName:ScheduleMapper
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/3/3 20:08
 * @Version 1.0
 */
public interface ScheduleMapper {

    List<Schedule> queryList();

    int delete(int id);

    int save(Schedule schedule);

    int update(Schedule schedule);
}
