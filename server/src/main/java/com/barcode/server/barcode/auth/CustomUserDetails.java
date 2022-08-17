package com.barcode.server.barcode.auth;

import com.barcode.server.barcode.dao.User;
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
public class UserDetailsImpl implements UserDetails {
    private static final long serrialVersionUID = 1L;
    private final User user;
    private static final String ROLE_PREFIX = "ROLE_";

    public UserDetailsImpl(User user){
        this.user=user;
    }

    @Override
    public String getPassword(){
        return user.getPassword();
    }
    @Override
    public String getUsername(){
        return user.getEmail();
    }
    @Override
    public boolean isAccountNonExpired(){
        return true;
    }
    @Override
    public boolean isAccountNonLocked(){
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired(){
        return true;
    }
    @Override
    public boolean isEnabled(){
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(user.getRole().toString());
        Collection<GrantedAuthority> authorities = new ArrayList<>(); //List인 이유 : 여러개의 권한을 가질 수 있다
        authorities.add(authority);
        return authorities;
    }

}
