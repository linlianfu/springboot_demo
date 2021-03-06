package com.example.demo.gateway.web.admin;

import cn.eleven.common.exception.BasicRuntimeException;
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
 *   1。访问路径  http://localhost:8080/springBoot/web/admin/userManager/userInfo/asdasd
 *   domain+context-path+servlet+controller+method(区分是否适用标准restful)
 */
@Slf4j
@RestController
@RequestMapping("userManager")
@EnableConfigurationProperties(HttpProperty.class)
@ConditionalOnProperty(prefix = "http.property",name = "test",havingValue = "enable")
public class UserManagerAction {
    UserManagerAction(){
        log.info("userManager 初始化");
    }


    @Autowired
    HttpProperty httpProperty;

    @GetMapping("userInfo/{name}")
    public String getUserInfo(@PathVariable String name){
        log.info("info");
        log.warn("warn");
        log.error("error");
        log.warn(httpProperty.getMessage());

        if (name.equals("111"))
            throw new BasicRuntimeException("111啦");
        return "eleven";
    }
}
