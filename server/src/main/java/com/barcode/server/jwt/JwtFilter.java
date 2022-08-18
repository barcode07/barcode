package com.barcode.server.jwt;

import com.barcode.server.barcode.auth.CustomUserDetailsService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * PackageName : com.barcode.server.jwt
 * FileName : JwtFilter
 * Author : 이 수 경
 * Date : 2022-08-16
 * Description :
 */

public class JwtFilter {

    public static final String AUTHORIZATION_HEADER = "Authorization";
    public static final String BEARER_PREFIX = "Bearer ";
    private CustomUserDetailsService customUserDetailsService;
    private AuthenticationManager authenticationManager;

//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        JwtTokenManager jwtTokenManager = new JwtTokenManager();
//        if(isContainToken(request)) {
//            // 1. 여기서 jwt 토큰을 받아서 앞에 Bearer을 자르고 문자열로 반환한다.
//            String jwt = resolveToken(request);
//            System.out.println(jwt);
//
//            // 2. 들어온 토큰이 유효한 토큰인지 검사를 한다. 만약에 유효한 토큰이라면 스프링 시큐리티에 인가를 저장한다. 그리고서 계속 필터작업을 이어서 한다.
//            if (StringUtils.hasText(jwt) && jwtTokenManager.validateToken(jwt)) {
//                UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken("dobby@dobby.com","P@ssw0rd!");
//                System.out.println(token);
//                Authentication authentication = authenticationManager.authenticate(token);
//                SecurityContextHolder.getContext().setAuthentication(authentication);
//            }
//        }
//        filterChain.doFilter(request, response);
//        }



    public Collection<GrantedAuthority> getAuthorities(String role) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role));
        return authorities;
    }

        private boolean isContainToken(HttpServletRequest request) {
            String token = request.getHeader("Authorization");
            return token != null;
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
