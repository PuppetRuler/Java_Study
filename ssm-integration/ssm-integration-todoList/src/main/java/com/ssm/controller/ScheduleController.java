package com.ssm.controller;

import com.ssm.pojo.Schedule;
import com.ssm.service.ScheduleService;
import com.ssm.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName:ScheduleController
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/3/3 20:06
 * @Version 1.0
 */
@CrossOrigin //允许其他源访问我们的controller 浏览器大哥就不拦截了!
@RestController
@RequestMapping("schedule")
@Slf4j
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @GetMapping("/{pageSize}/{currentPage}")
    public R page(@PathVariable int pageSize,@PathVariable int currentPage){
        R r = scheduleService.page(pageSize, currentPage);
        //slf4j
        log.info("查询的数据为:{}",r);

        return r;
    }

    @DeleteMapping("/{id}")
    public R delete(@PathVariable int id){
        R r = scheduleService.delete(id);
        return r;
    }

    @PostMapping
    public R save(@Validated @RequestBody Schedule schedule, BindingResult result){
        if (result.hasErrors()){
            return R.fail("参数错误");
        }
        R r = scheduleService.save(schedule);

        return r;
    }

    @PutMapping
    public R update(@Validated @RequestBody Schedule schedule, BindingResult result){
        if (result.hasErrors()){
            return R.fail("参数错误");
        }
        R r = scheduleService.update(schedule);

        return r;
    }
}
