package com.example.demo.service.courseManager.south;

import cn.eleven.common.dao.Page;
import com.example.demo.dao.CourseDao;
import com.example.demo.model.CoursePO;
import com.example.demo.service.courseManager.ICourseManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.mongodb.core.query.UntypedExampleMatcher;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
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


    @Override
    public List<CoursePO> listBySpecification() {

        List<CoursePO> all = courseDao.findAll((Specification<CoursePO>) (root, query, criteriaBuilder) -> {
            Predicate nameCondition = criteriaBuilder.like(root.get("name"), "%测试%");
            Predicate period = criteriaBuilder.ge(root.get("period"), 10);
            query.where(nameCondition,period);
            return null;
        });

        all.forEach(p->log.info(p.toString()));
        return all;
    }

    @Override
    public Page<CoursePO> page() {
        org.springframework.data.domain.Page<CoursePO> page = courseDao.findAll((Specification<CoursePO>) (root, query, criteriaBuilder) -> null, PageRequest.of(1, 2));
        List<CoursePO> content = page.getContent();
        content.forEach(p->{
            log.info("分页内容:{}",p.toString());
        });
        Page result = new Page();
        result.setCurrentPageData(content);
        result.setTotalSize(page.getTotalElements());
        result.setTotalPageSize(page.getTotalPages());
        result.setPageSize(page.getSize());
        log.info(page.toString());
        return result;
    }


    @Override
    public CoursePO add(CoursePO entity) {
        CoursePO result = courseDao.save(entity);
        log.info("新增结果:{}",result);
        return result;
    }
}
