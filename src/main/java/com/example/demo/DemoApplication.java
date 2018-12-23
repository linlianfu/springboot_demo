package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 当前启动类和之定义的controller不在同一个包下的时候，需要指定要扫描的包
 */
@ComponentScan(basePackages = "com.example.action")
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
//		SpringApplication application = new SpringApplication(DemoApplication.class);
//		application.setBannerMode(Banner.Mode.OFF);
//		application.run(args);
	}
}
