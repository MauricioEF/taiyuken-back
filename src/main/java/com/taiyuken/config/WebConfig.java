package com.taiyuken.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000","https://taiyuken.com")
                .allowedHeaders("*")
                .allowedMethods("GET","POST")
                .allowCredentials(true);
    }
}
