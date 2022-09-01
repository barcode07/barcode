package com.barcode.server.barcode.handler;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * PackageName : com.barcode.server.barcode.handler
 * FileName : CustomAccessDeniedHandler
 * Author : 이 수 경
 * Date : 2022-08-31
 * Description :
 */
public class CustomAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
//        인증은 되었으나 접근 권한이 없는 사용자 처리
        System.out.println("권한이 없는 사용자의 접근입니다.");
        response.sendError(403,"권한이 없는 사용자 접근입니다.");
    }
}
