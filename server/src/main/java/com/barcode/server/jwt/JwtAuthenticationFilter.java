package com.barcode.server.jwt;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.web.filter.OncePerRequestFilter;

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
//public class JwtAuthenticationFilter extends GenericFilterBean {
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    public static final String AUTHORIZATION_HEADER = "Authorization";
    public static final String BEARER_PREFIX = "Bearer ";
    private JwtTokenManager jwtTokenManager;

    public JwtAuthenticationFilter(JwtTokenManager jwtTokenManager) {
        this.jwtTokenManager = jwtTokenManager;
    }

//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        String token = resolveToken((HttpServletRequest)request);
//        if (token != null && jwtTokenManager.validateToken(token)) {   // token 검증
//            System.out.println("토큰을 검증하고 인증객체를 생성");
//            Authentication auth = jwtTokenManager.getAuthentication(token);    // 인증 객체 생성
//            SecurityContextHolder.getContext().setAuthentication(auth); // SecurityContextHolder에 인증 객체 저장
//        }
//        System.out.println("필터를 통과하였다....");
//        chain.doFilter(request, response);
//    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = resolveToken((HttpServletRequest)request);
        if (token != null && jwtTokenManager.validateToken(token)) {   // token 검증
            // System.out.println("토큰을 검증하고 인증객체를 생성");
            Authentication auth = jwtTokenManager.getAuthentication(token);    // 인증 객체 생성
            SecurityContextHolder.getContext().setAuthentication(auth); // SecurityContextHolder에 인증 객체 저장
            // System.out.println("인증 객체:" + SecurityContextHolder.getContext().getAuthentication().getPrincipal());
            // System.out.println("인증 객체:" + SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString());
        }
        filterChain.doFilter(request, response);

    }

    //  토큰의 정보를 가져오는 메소드
    private String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }
}
