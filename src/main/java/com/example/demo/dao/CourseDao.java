package com.example.demo.dao;

import com.example.demo.model.CoursePO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author eleven
 * @date 2019/3/29
 * @description
 */
public interface CourseDao extends JpaRepository<CoursePO,String> {

}
