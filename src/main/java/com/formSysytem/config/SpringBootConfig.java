package com.formSysytem.config;

import com.formSysytem.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.servlet.handler.MappedInterceptor;

/**
 * @author U
 * @className: SpringBootConfig
 * @description: TODO
 * @date 2023/11/17 22:27
 */
@Configuration
public class SpringBootConfig {
    @Bean
    public MappedInterceptor loginInterceptor() {
        return new MappedInterceptor(new String[]{"/**"},
                new LoginInterceptor());
    }
}
