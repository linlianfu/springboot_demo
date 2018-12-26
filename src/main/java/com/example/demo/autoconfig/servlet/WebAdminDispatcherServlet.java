package com.example.demo.autoconfig.servlet;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @author eleven
 * @date 2018/12/26
 * @description admin的dispatcherServlet注册
 */
@Configuration
public class WebAdminDispatcherServlet implements WebApplicationInitializer {


    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        XmlWebApplicationContext appContext = new XmlWebApplicationContext();
        appContext.setConfigLocation("classpath:spring/spring-boot-mvc-web-admin.xml");

        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("spring-boot-mvc-web-admin", new DispatcherServlet(appContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/web/admin");
}
}
