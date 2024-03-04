package com.ssm.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.mapper.ScheduleMapper;
import com.ssm.pojo.Schedule;
import com.ssm.service.ScheduleService;
import com.ssm.utils.PageBean;
import com.ssm.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName:ScheduleServiceImpl
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/3/3 20:07
 * @Version 1.0
 */
@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleMapper scheduleMapper;

    @Override
    public R page(int pageSize, int currentPage) {
        // 分页
        PageHelper.startPage(currentPage, pageSize);
        // 查询
        List<Schedule> scheduleList = scheduleMapper.queryList();
        // 分页数据装配
        PageInfo<Schedule> info = new PageInfo<>(scheduleList);
        // 装配PageBean
        PageBean<Schedule> pageBean = new PageBean<>(currentPage, pageSize, info.getTotal(), info.getList());

        R ok = R.ok(pageBean);
        return ok;
    }

    @Override
    public R delete(int id) {
        int rows = scheduleMapper.delete(id);
        if (rows > 0) {
            return R.ok(null);
        }
        return R.fail(null);
    }

    @Override
    public R save(Schedule schedule) {
        int rows = scheduleMapper.save(schedule);
        if (rows > 0) {
            return R.ok(null);
        }
        return R.fail(null);
    }

    @Override
    public R update(Schedule schedule) {
        // 判断id为空
        if (schedule.getId() == null){
            return R.fail(null);
        }
        int rows = scheduleMapper.update(schedule);
        return R.ok(null);
    }
}
