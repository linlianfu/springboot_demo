package com.example.demo.autoconfig.mvc;

import cn.eleven.common.intercept.WrappedHandlerExceptionResolver;
import cn.eleven.common.intercept.WriteFastJsonHttpMessageConverter;
import com.example.demo.autoconfig.interpect.UserLoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import java.util.List;

/**
 * @author eleven
 * @date 2018/12/22
 * @description
 */
@Configuration
public class GlobalWebmvcConfiguration implements WebMvcConfigurer {


    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(converter());
    }

    @Override
    public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
        resolvers.add(exceptionResolver());
    }

    /**
     * 只有经过DispatcherServlet才会进入拦截器，自定义的servlet是不会被拦截器拦截的！！！！-why?
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new UserLoginInterceptor());
        registry.addInterceptor(getUserLoginInterceptor()).addPathPatterns("/web/admin/**");
    }

    @Bean
    public WriteFastJsonHttpMessageConverter converter() {
        return new WriteFastJsonHttpMessageConverter();
    }

    @Bean
    public WrappedHandlerExceptionResolver exceptionResolver() {
        return new WrappedHandlerExceptionResolver();
    }
    @Bean
    public HandlerInterceptorAdapter getUserLoginInterceptor() {
        return new UserLoginInterceptor();
    }

    /**
     * 配置静态资源的访问路径
     * http://localhost:8080/会默认定向到public 或者 static或者resoruce下的index.html，找到任意一个即返回
     *
     * eg: http://localhost:8080/static/index.html
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
}
