package com.example.demo.autoconfig;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author eleven
 * @date 2018/12/23
 * @description
 */
@Configuration
@EnableWebMvc
public class WebServletRegistrationBean {


    @Bean
    public ServletRegistrationBean registerAdminServlet(){

        //注解扫描上下文
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        //base package
        applicationContext.scan("com.example.action");
        //通过构造函数指定dispatcherServlet的上下文
        DispatcherServlet adminDispatcherServlet = new DispatcherServlet(applicationContext);

        //用ServletRegistrationBean包装servlet
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(adminDispatcherServlet);
        registrationBean.setLoadOnStartup(1);
        //指定url映射
        registrationBean.addUrlMappings("/web/admin/*");
        //指定name，如果不指定默认为dispatcherServlet
        registrationBean.setName("spring-mvc-web-admin");

        return registrationBean;
    }
}
