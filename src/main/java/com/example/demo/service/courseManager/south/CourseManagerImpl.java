package com.example.demo.service.courseManager.south;

import com.example.demo.dao.CourseDao;
import com.example.demo.model.CoursePO;
import com.example.demo.service.courseManager.ICourseManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.mongodb.core.query.UntypedExampleMatcher;
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

        CoursePO queryDto = new CoursePO();
        queryDto.setName("测试排他锁111");

        UntypedExampleMatcher untypedExampleMatcher = UntypedExampleMatcher.matchingAny()
                .withIgnorePaths("id","period","abouts","delete","enable","iconPath")
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING).withIgnoreNullValues();
        Example<CoursePO> example = Example.of(queryDto,untypedExampleMatcher);
        List<CoursePO> conditionList = courseDao.findAll(example);
        return all;
    }
}
