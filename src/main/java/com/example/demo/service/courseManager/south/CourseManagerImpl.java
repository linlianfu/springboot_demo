package com.example.demo.service.courseManager.south;

import com.example.demo.dao.CourseDao;
import com.example.demo.model.CoursePO;
import com.example.demo.service.courseManager.ICourseManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author eleven
 * @date 2019/3/29
 * @description
 */
@Slf4j
@Service
public class CourseManagerImpl implements ICourseManager {

    @Autowired
    CourseDao courseDao;

    @Override
    public List<CoursePO> findAll() {
        List<CoursePO> all = courseDao.findAll();

        all.forEach(p->log.info(p.toString()));
        return all;
    }
}
