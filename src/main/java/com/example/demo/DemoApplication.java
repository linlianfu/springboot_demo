package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * 当前启动类和自定义的controller不在同一个包下的时候，需要指定要扫描的包
 */
//@ComponentScan(basePackages = "com.example.action")
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
//		SpringApplication application = new SpringApplication(DemoApplication.class);
//		application.setBannerMode(Banner.Mode.OFF);
//		application.run(args);
	}

	/**
	 * 使用了@EnableWebMvc，就需要指定的试图模板，否则通过controller访问html，将出现 找不到html的页面
	 * 具体原因带研究
	 * @return
	 */
	@Bean
	public InternalResourceViewResolver setupViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		/** 设置视图路径的前缀 */
		resolver.setPrefix("/static/");
		/** 设置视图路径的后缀 */
		resolver.setSuffix(".html");
		return resolver;
	}
}
