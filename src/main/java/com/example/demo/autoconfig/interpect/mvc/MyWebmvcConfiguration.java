package com.example.demo.autoconfig.interpect.mvc;

import cn.eleven.common.intercept.WrappedHandlerExceptionResolver;
import cn.eleven.common.intercept.WriteFastJsonHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @author eleven
 * @date 2018/12/22
 * @description
 */
@Configuration
public class MyWebmvcConfiguration implements WebMvcConfigurer {


    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(converter());
    }

    @Override
    public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
        resolvers.add(exceptionResolver());
    }

    @Bean
    public WriteFastJsonHttpMessageConverter converter() {
        return new WriteFastJsonHttpMessageConverter();
    }

    @Bean
    public WrappedHandlerExceptionResolver exceptionResolver() {
        return new WrappedHandlerExceptionResolver();
    }
}
