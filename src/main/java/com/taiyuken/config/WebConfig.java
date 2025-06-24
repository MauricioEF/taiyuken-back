package com.taiyuken.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000","http://127.0.0.1:3000","https://taiyuken.com","https://www.taiyuken.com")
                .allowedHeaders("*")
                .allowedMethods("GET","POST")
                .allowCredentials(true);
    }
}
