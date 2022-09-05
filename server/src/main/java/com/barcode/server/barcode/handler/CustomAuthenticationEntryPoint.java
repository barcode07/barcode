package com.barcode.server.barcode.handler;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * PackageName : com.barcode.server.barcode.handler
 * FileName : CustomAuthenticationEntryPoint
 * Author : 이 수 경
 * Date : 2022-08-31
 * Description :
 */
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
//        인증되지 않은 사용자 처리
//        System.out.println("인증되지 않는 사용자의 접근입니다.");
//        토큰을 검증을 했는데 토큰이 유효하지 않으면 일로온다.
        response.sendError(401,"권한이 없는 사용자 접근입니다.");
    }
}
