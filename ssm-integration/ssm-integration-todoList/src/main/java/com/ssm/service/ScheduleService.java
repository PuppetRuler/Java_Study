package com.ssm.service;

import com.ssm.pojo.Schedule;
import com.ssm.utils.R;

/**
 * ClassName:ScheduleService
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/3/3 20:07
 * @Version 1.0
 */
public interface ScheduleService {
    R page(int pageSize,int currentPage);

    R delete(int id);

    R save(Schedule schedule);

    R update(Schedule schedule);
}
