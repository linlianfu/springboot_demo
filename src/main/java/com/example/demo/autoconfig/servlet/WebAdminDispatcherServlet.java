package com.example.demo.autoconfig.servlet;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @author eleven
 * @date 2018/12/26
 * @description admin的dispatcherServlet注册
 *
 * 1，参考springboot启动全过程：https://blog.csdn.net/findbestoy/article/details/79749438
 *
 * 带研究文章：https://blog.csdn.net/songhaifengshuaige/article/details/54138023
 */
@Slf4j
@Configuration
public class WebAdminDispatcherServlet implements ServletContextInitializer {

    public WebAdminDispatcherServlet(){
        log.info("admin servlet初始化");
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        log.info(">>>>>admin servlet初始化");
        XmlWebApplicationContext appContext = new XmlWebApplicationContext();
        appContext.setConfigLocation("classpath:config/spring/mvc/spring-boot-mvc-web-admin.xml");
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("spring-boot-mvc-web-admin", new DispatcherServlet(appContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/web/admin/*");
    }
}
