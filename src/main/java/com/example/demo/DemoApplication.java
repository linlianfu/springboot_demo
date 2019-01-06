package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * 当前启动类和自定义的controller不在同一个包下的时候，需要指定要扫描的包
 * springboot learning:https://github.com/cmlbeliever/SpringBootLearning/tree/master/LearnTest/src
 */
//@SpringBootApplication
@SpringBootConfiguration
@EnableAutoConfiguration
abstract @ComponentScan(
        excludeFilters = {
                @ComponentScan.Filter(
                        type = FilterType.ANNOTATION,
                        classes = {
                                Controller.class, RestController.class
                        })
        }
)
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
//		SpringApplication application = new SpringApplication(DemoApplication.class);
//		application.setBannerMode(Banner.Mode.OFF);
//		application.run(args);
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
		servletRegistrationBean.setMultipartConfig();
	}

	/**
     * 使用 @EnableWebMvc 注解，需要以编程的方式指定视图文件相关配置；
	 * 就需要指定的试图模板，否则通过controller访问html，将出现 找不到html的页面
	 * 具体原因带研究
	 * @return
	 */
//	@Bean
//	public InternalResourceViewResolver setupViewResolver() {
//		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//		/** 设置视图路径的前缀 */
//		resolver.setPrefix("/static/");
//		/** 设置视图路径的后缀 */
//		resolver.setSuffix(".html");
//		return resolver;
//	}
}
