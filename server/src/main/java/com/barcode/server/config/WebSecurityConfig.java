
package com.barcode.server.config;
import com.barcode.server.barcode.handler.CustomAccessDeniedHandler;
import com.barcode.server.jwt.JwtAuthenticationFilter;
import com.barcode.server.jwt.JwtTokenManager;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        securedEnabled = true,
        jsr250Enabled = true,
        prePostEnabled = true
)
@AllArgsConstructor
public class WebSecurityConfig {

    private final JwtTokenManager jwtTokenManager;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

<<<<<<< HEAD
=======
//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//    return (web) -> web.ignoring().mvcMatchers("/error", "/swagger-ui/**","/swagger-ui.html", "/swagger/**", "/swagger-resources/**","/v3/api-docs","/v3/api-docs/**","/**/*.png",
//        "/**/*.gif",
//        "/**/*.svg",
//        "/**/*.jpg",
//        "/**/*.html",
//        "/**/*.css",
//        "/**/*.js");
//    }

>>>>>>> 1c7d14314658c1a463824e558e22bced466a0aee
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
//                .httpBasic().disable()
//                .cors().disable()
                .cors().configurationSource(corsConfigurationSource())
                .and()
                .csrf().disable()
                .formLogin().disable()
                .headers()
                .frameOptions()
                .sameOrigin()
                .and()
//                .antMatchers("/**").permitAll()
                .authorizeRequests()
<<<<<<< HEAD
                .antMatchers("/error", "/swagger-ui/**","/swagger-ui.html","/swagger/**", "/swagger-resources/**","/v3/api-docs","/v3/api-docs/**","/**/*.png","/**/*.gif","/**/*.svg","/**/*.jpg","/**/*.html","/**/*.css","/**/*.js").permitAll()
                .antMatchers("/user/test").hasRole("USER")
                .antMatchers("/user/**").permitAll()
//                .antMatchers("/**").permitAll()
                .anyRequest().authenticated()
//                .and()
//                .exceptionHandling()
//                인증되지 않은 사용자 처리
//                .accessDeniedHandler(new CustomAccessDeniedHandler())
//                인증은 되었고 권한이 없는 사용자 처리
//                .authenticationEntryPoint(new CustomAuthenticationEntryPoint())
                .and()
                // jwt를 사용하므로 spring security의 session은 필요가 없다.
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
=======
                .antMatchers("/**").permitAll()
                .antMatchers("/error", "/swagger-ui/**","/swagger-ui.html","/swagger/**", "/swagger-resources/**","/v3/api-docs","/v3/api-docs/**","/**/*.png","/**/*.gif","/**/*.svg","/**/*.jpg","/**/*.html","/**/*.css","/**/*.js").permitAll()
//                .antMatchers("/user/**").permitAll()
//                .antMatchers("/test").hasRole("USER")
//                .anyRequest().authenticated()
>>>>>>> 1c7d14314658c1a463824e558e22bced466a0aee
                .and()
//               첫번째 인자로 필터를 넣어주고, 두번째 인자로 어떤 필터전에 실행 시킬지 필터를 넣어준다.
//                .addFilterBefore(new JwtAuthenticationFilter(jwtTokenManager), UsernamePasswordAuthenticationFilter.class);
                .addFilterBefore(new JwtAuthenticationFilter(jwtTokenManager), UsernamePasswordAuthenticationFilter.class);
<<<<<<< HEAD
=======
//                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
//                .exceptionHandling()
//                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
//                .and()
//                .apply(new JwtSecurityConfig(jwtTokenManager));

//        			.authorizeRequests()
//                .antMatchers("/api/members/signup", "/api/members/signin").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .disable()
//                .csrf()
//                .disable()
//                .headers()
//                .disable()
//                .httpBasic()
//                .disable()
//                .rememberMe()
//                .disable()
//                .logout()
//                .disable()
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .exceptionHandling()
//                .accessDeniedHandler(accessDeniedHandler())
//                .authenticationEntryPoint(authenticationEntryPoint())

>>>>>>> 1c7d14314658c1a463824e558e22bced466a0aee
        return http.build();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("http://localhost:3000");
        configuration.setAllowedMethods(Arrays.asList("GET","POST", "OPTIONS", "PUT","DELETE"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

}