package com.example.demo.gateway.web.admin;

import cn.eleven.common.dao.Page;
import com.example.demo.model.CoursePO;
import com.example.demo.service.courseManager.ICourseManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author eleven
 * @date 2019/3/29
 * @description
 */
@Slf4j
@RestController
@RequestMapping("courseManager")
public class CourseManagerAction {

    @Autowired
    private ICourseManager courseManager;

    /**
     * 获取所有课程
     * @return
     */
    @GetMapping("all")
    public List<CoursePO> findAll(){
        return courseManager.findAll();
    }
    /**
     * 获取所有课程
     * @return
     */
    @GetMapping("listBySpecification")
    public List<CoursePO> listBySpecification(){
        return courseManager.listBySpecification();
    }
    /**
     * 获取分页课程
     * @return
     */
    @GetMapping("page")
    public Page<CoursePO> page(){
        return courseManager.page();
    }
    /**
     * 新增数据
     * @return
     */
    @PostMapping("add")
    public CoursePO add(@RequestBody CoursePO entity){
        return courseManager.add(entity);
    }
}
