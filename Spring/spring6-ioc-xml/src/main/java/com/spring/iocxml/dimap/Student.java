package com.spring.iocxml.dimap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private List<Lesson> lessonList;
    private Map<String,Teacher> teacherMap;

    private String sid;
    private String sname;

    public void run() {
        System.out.println("学生编号： "+sid+ "学生名称："+sname);
        System.out.println(teacherMap);
        System.out.println(lessonList);
    }
}
