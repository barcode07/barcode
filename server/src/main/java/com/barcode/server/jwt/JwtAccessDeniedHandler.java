package com.barcode.server.jwt;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * PackageName : com.barcode.server.jwt
 * FileName : JwtAccessDeniedHandler
 * Author : 이 수 경
 * Date : 2022-08-15
 * Description :
 */
//@Component
//public class JwtAccessDeniedHandler implements AccessDeniedHandler {
//
//    @Override
//    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
//        // 필요한 권한이 없이 접근하려 할때 403
//        response.sendError(HttpServletResponse.SC_FORBIDDEN);
//    }
//}