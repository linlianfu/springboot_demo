package com.example.demo.autoconfig;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author eleven
 * @date 2018/12/21
 * @description
 */
@Data
@ConfigurationProperties(prefix = "http.property")
public class HttpProperty {

    private String message = "world";

    private String name = "hello";
}
