package com.formSysytem.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author U
 * @className: WebAppConfigurer
 * @description: TODO
 * @date 2023/11/23 22:27
 */
@Configuration
public class WebAppConfigurer implements WebMvcConfigurer {


    /**
     * 解决跨越问题
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:8080") // 允许的前端来源
                .allowedMethods("GET", "HEAD", "POST", "PUT",
                        "DELETE", "OPTIONS")
                .allowCredentials(true); // 允许发送凭据（例如，cookies）
    }



}
