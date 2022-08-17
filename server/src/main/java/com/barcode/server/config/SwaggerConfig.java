package com.barcode.server.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * PackageName : com.example.ssssksss_blog.config
 * FileName : SwaagerConfig
 * Author : 이 수 경
 * Date : 2022-05-11
 * Description :
 */
//http://localhost:8080/swagger-ui/index.html
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.barcode.server.barcode.controller"))
                .paths(PathSelectors.any())
                .build()
//                .groupName("")
//                pathMapping("/")
                .tags(new Tag("sample", "this is sample"))
//                .securitySchemes(L ist.of(apiKey()))
//                .securityContexts(L ist.of(securityContext()));
                .apiInfo(apiInfo());
    }

//    swaager 페이지에서 보이는 내용을 설정하는 곳
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Barcode Swagger") // swagger 타이틀 제목
                .description("barcode swaager api docs") // 설명
                .version("1.0") // version 보이는것
                .build();
    }
}

//public class SwaggerConfig implements WebMvcConfigurer {
//    private final String baseUrl;
//
//    public SwaggerConfig(String baseUrl) {
//        this.baseUrl = baseUrl;
//    }
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        String baseUrl = StringUtils.trimTrailingCharacter(this.baseUrl, '/');
//        registry.
//                addResourceHandler(baseUrl + "/swagger-ui/**")
//                .addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/")
//                .resourceChain(false);
//    }
//
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController(baseUrl + "/swagger-ui/")
//                .setViewName("forward:" + baseUrl + "/swagger-ui/index.html");
//    }
//}

