package com.barcode.server.filter;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.stereotype.Component;
import springfox.documentation.oas.web.OpenApiTransformationContext;
import springfox.documentation.oas.web.WebMvcOpenApiTransformationFilter;
import springfox.documentation.spi.DocumentationType;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * PackageName : com.barcode.server.filter
 * FileName : Workaround
 * Author : 이 수 경
 * Date : 2022-08-18
 * Description :
 */
//@Component
//public class Workaround implements WebMvcOpenApiTransformationFilter {
//
//    @Override
//    public OpenAPI transform(OpenApiTransformationContext<HttpServletRequest> context) {
//        OpenAPI openApi = context.getSpecification();
//        Server localServer = new Server();
//        localServer.setDescription("local");
//        localServer.setUrl("http://localhost:8080");
//
//        Server testServer = new Server();
//        testServer.setDescription("dev");
//        testServer.setUrl("http://barcode-server.ssssksss.xyz");
//                openApi.setServers(Arrays.asList(localServer, testServer));
//        return openApi;
//    }
//
//    @Override
//    public boolean supports(DocumentationType documentationType) {
//        return documentationType.equals(DocumentationType.OAS_30);
//    }
//}