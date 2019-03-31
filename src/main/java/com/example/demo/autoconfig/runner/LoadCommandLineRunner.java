package com.example.demo.autoconfig.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author eleven
 * @date 2019/3/30
 * @description
 */
@Slf4j
@Component
@Order(value = 2)
public class LoadCommandLineRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        log.info(">>>>>服务启动加载数据,加载第二项数据");
    }
}
