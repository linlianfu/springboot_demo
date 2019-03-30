package com.example.demo.service.courseManager;

import cn.eleven.common.dao.Page;
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

    /**
     * 通过Specification指定条件查询
     * @return
     */
    List<CoursePO> listBySpecification();

    /**
     * 分页查询
     * @return
     */
    Page<CoursePO> page();

    /**
     * 新增数据
     */
    CoursePO add(CoursePO entity);
}
