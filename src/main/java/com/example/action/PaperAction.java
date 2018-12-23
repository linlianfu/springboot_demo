package com.example.action;

import com.example.demo.autoconfig.HttpProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author eleven
 * @date 2018/12/15
 * @description
 */
@Slf4j
@RestController
@RequestMapping("paperManager")
@EnableConfigurationProperties(HttpProperty.class)
@ConditionalOnProperty(prefix = "http.property",name = "test",havingValue = "12341234")
public class PaperAction {


    @Autowired
    HttpProperty httpProperty;

    @GetMapping("paper/{id}")
    public String getUserInfo(@PathVariable String id){
        log.info("==================");
        log.info(id);
        return id;
    }
}
