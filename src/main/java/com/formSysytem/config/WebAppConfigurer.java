package com.hulon.diangsang.config;

import com.hulon.diangsang.interceptor.SysInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * web项目配置类
 * @author Hulon
 * @date 2023/7/20
 * @className WebAppConfigurer
 */
@Configuration
public class WebAppConfigurer implements WebMvcConfigurer {




    /**
     *     解决跨越问题
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET", "HEAD", "POST", "PUT",
                        "DELETE","OPTIONS")
                .maxAge(3600);
    }
    /**
     * 图片路径配置
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        //头像
        registry.addResourceHandler("/image/avatar/**").addResourceLocations("file:D:\\图片\\微信电商图片\\avatar\\");

        registry.addResourceHandler("/image/swiper/**").addResourceLocations("file:D:\\图片\\微信电商图片\\swiper\\");
        registry.addResourceHandler("/image/bigType/**").addResourceLocations("file:D:\\图片\\微信电商图片\\bigType\\");
        registry.addResourceHandler("/image/product/**").addResourceLocations("file:D:\\图片\\微信电商图片\\productImgs\\");
        registry.addResourceHandler("/image/productSwiperImgs/**").addResourceLocations("file:D:\\图片\\微信电商图片\\productSwiperImgs\\");
        registry.addResourceHandler("/image/productParaImgs/**").addResourceLocations(("file:D:\\图片\\微信电商图片\\productParaImgs\\"));
        registry.addResourceHandler("/image/productIntroImgs/**").addResourceLocations(("file:D:\\图片\\微信电商图片\\productIntroImgs\\"));
    }

    @Bean
    public SysInterceptor sysInterceptor(){
        return new SysInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] patterns = new String[]{"/admin/login","/product/**","/bigType/**","/user/wxlogin","/weixinpay/**","/xrebel/**","/swiper/**","/avatar/**","/productSwiperImgs/**",
        "/productParaImgs/**","/productIntroImgs/**"};
        registry.addInterceptor(sysInterceptor()).
                addPathPatterns("/**").
                excludePathPatterns(patterns);
    }
}
