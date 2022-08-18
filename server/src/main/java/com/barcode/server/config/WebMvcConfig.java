package com.barcode.server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**")
//                .allowedMethods("GET","POST","*") // 허용할 http 메소드
                .allowedHeaders("*")
                .allowedMethods("*") // 허용할 http 메소드
                .maxAge(5000) //pre-flight 리퀘스트 캐싱
                .allowedOriginPatterns("*")
                .allowCredentials(true);

//                .allowedMethods("GET","POST","PUT","PATCH","DELETE","OPTIONS")
//                .allowedOrigins("*")
//                .allowedOrigins("http://localhost:3000","http://localhost:8080","http://barcode-server.ssssksss.xyz",
//                        "http://ssssksss.xyz")
//                .allowedOrigins("https://blog.ssssksss.xyz");
    }

}