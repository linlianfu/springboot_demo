package com.example.demo;

import lombok.extern.slf4j.Slf4j;
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
public class UserManagerAction {


    @GetMapping("getUserInfo")
    public String getUserInfo(){
        log.info("info");
        log.warn("warn");
        log.error("error");
        return "eleven";
    }
}
