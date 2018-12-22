package com.example.demo;

import com.example.demo.autoconfig.HttpProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author eleven
 * @date 2018/12/15
 * @description
 */
@Slf4j
@RestController
@RequestMapping("userManager")
@EnableConfigurationProperties(HttpProperty.class)
@ConditionalOnProperty(prefix = "http.property",name = "test",havingValue = "12341234")
public class UserManagerAction {


    @Autowired
    HttpProperty httpProperty;

    @GetMapping("getUserInfo")
    public String getUserInfo(){
        log.info("info");
        log.warn("warn");
        log.error("error");
        log.warn(httpProperty.getMessage());
        return "eleven";
    }
}
