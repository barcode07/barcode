package com.barcode.server.barcode.auth;

import com.barcode.server.barcode.dao.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * PackageName : com.barcode.server.barcode.auth
 * FileName : UserDetailsLmpl
 * Author : 이 수 경
 * Date : 2022-08-15
 * Description :
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomUserDetails implements UserDetails {
    private static final long serrialVersionUID = 1L;

    private String username;
    private String password;
    @Builder.Default
    private boolean isEnabled = true;
    @Builder.Default
    private boolean isAccountNonExpired = true;
    @Builder.Default
    private boolean isAccountNonLocked = true;
    @Builder.Default
    private boolean isCredentialsNonExpired = true;
    private Collection<? extends GrantedAuthority> authorities;

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities(){
//        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(user.getRole().toString());
//        Collection<GrantedAuthority> authorities = new ArrayList<>(); //List인 이유 : 여러개의 권한을 가질 수 있다
//        authorities.add(authority);
//        return authorities;
//    }

}
