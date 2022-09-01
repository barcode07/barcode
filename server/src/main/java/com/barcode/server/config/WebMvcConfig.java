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
<<<<<<< HEAD
                .allowedOriginPatterns("*")
//                .allowedOrigins("http://localhost:3000")
=======
//                .allowedOriginPatterns("*")
                .allowedOrigins("http://localhost:3000","http://localhost:8080","http://barcode-server.ssssksss.xyz",
                        "http://ssssksss.xyz")
>>>>>>> 1c7d14314658c1a463824e558e22bced466a0aee
                .allowCredentials(true);

//        ===================
//        둘 중에 1개 선택해서 사용
//        .allowedOrigins("*")
//        .allowCredentials(false);
//        혹은
//        .allowedOriginPatterns("*")
//        .allowCredentials(true);
//        ===================
    }

}