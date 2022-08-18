
package com.barcode.server.config;
import com.barcode.server.jwt.JwtAuthenticationFilter;
import com.barcode.server.jwt.JwtFilter;
import com.barcode.server.jwt.JwtTokenManager;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

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

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
    return (web) -> web.ignoring().mvcMatchers("/error", "/swagger-ui/**","/swagger-ui.html", "/swagger/**", "/swagger-resources/**","/v3/api-docs","/v3/api-docs/**","/**/*.png",
        "/**/*.gif",
        "/**/*.svg",
        "/**/*.jpg",
        "/**/*.html",
        "/**/*.css",
        "/**/*.js");
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
//                .httpBasic().disable()
                .cors().disable()
                .csrf().disable()
                .formLogin().disable()
                .headers()
                .frameOptions()
                .sameOrigin()
//                .defaultAccessDeniedHandlerFor()
                .and()
                .authorizeRequests()
                .antMatchers("/**").permitAll()
//                .antMatchers("/user/**").permitAll()
//                .antMatchers("/test").hasRole("USER")
                .anyRequest().authenticated()
                .and()
//               첫번째 인자로 필터를 넣어주고, 두번째 인자로 어떤 필터전에 실행 시킬지 필터를 넣어준다.
                .addFilterBefore(new JwtAuthenticationFilter(jwtTokenManager), UsernamePasswordAuthenticationFilter.class);
//                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
//                .exceptionHandling()
//                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
//                .and()
//                .apply(new JwtSecurityConfig(jwtTokenManager))

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

        return http.build();
    }
}