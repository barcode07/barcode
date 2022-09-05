package com.barcode.server.barcode.handler;

import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class CustomAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
//        인증은 되었으나 접근 권한이 없는 사용자 처리
        System.out.println("권한이 없는 사용자의 접근입니다.");
        System.out.println("request.getCookies()[0].getValue() : " + request.getCookies()[0].getValue());
        log.info("request.getCookies()[0].getValue() : "+ request.getCookies()[0].getValue());
        if(request.getCookies()[0].getValue() != null) {
            response.sendError(403,"권한이 없는 사용자 접근입니다.");
        }
        if(true) {
            System.out.println("이거는 되니???? 도대체 왜 sysout가 안된느거야");
        }
    }
}
