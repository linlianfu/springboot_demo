package com.example.demo.service.courseManager;

import com.example.demo.model.CoursePO;

import java.util.List;

/**
 * @author eleven
 * @date 2019/3/29
 * @description
 */
public interface ICourseManager {

    /**
     * 查询所有课程
     * @return
     */
    List<CoursePO> findAll();
}
