package com.barcode.server.jwt;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * PackageName : com.barcode.server.config
 * FileName : JwtAuthenticationFilter
 * Author : 이 수 경
 * Date : 2022-08-16
 * Description :
 */
public class JwtAuthenticationFilter extends GenericFilterBean {

    public static final String AUTHORIZATION_HEADER = "Authorization";
    public static final String BEARER_PREFIX = "Bearer ";
    private JwtTokenManager jwtTokenManager;

    public JwtAuthenticationFilter(JwtTokenManager jwtTokenManager) {
        this.jwtTokenManager = jwtTokenManager;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String token = resolveToken((HttpServletRequest)request);
        if (token != null && jwtTokenManager.validateToken(token)) {   // token 검증
            Authentication auth = jwtTokenManager.getAuthentication(token);    // 인증 객체 생성
            SecurityContextHolder.getContext().setAuthentication(auth); // SecurityContextHolder에 인증 객체 저장
        }
        chain.doFilter(request, response);
    }

    //  토큰의 정보를 가져오는 메소드
    private String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader(AUTHORIZATION_HEADER);
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(BEARER_PREFIX)) {
            return bearerToken.substring(7);
        }
        return null;
    }
}
