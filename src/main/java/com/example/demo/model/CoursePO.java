package com.example.demo.model;

import cn.eleven.common.bean.superbean.PersistentBean;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author eleven
 * @date 2019/3/29
 * @description
 */
@Data
@Entity(name = "cre_course")
public class CoursePO implements PersistentBean {

    @Id
    @Column(name = "CSE_ID")
    private String id;

    @Column(name = "CSE_NAME")
    private String name;

    @Column(name = "CSE_PERIOD")
    private double period;

    @Column(name = "CSE_ABOUTS")
    private String abouts;

    @Column(name = "CSE_IS_DELETE")
    private int delete;

    @Column(name = "CSE_IS_ENABLED")
    private int enable;

    @Column(name = "CSE_ICON_PATH")
    private String iconPath;

}
