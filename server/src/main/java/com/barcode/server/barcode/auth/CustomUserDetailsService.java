package com.barcode.server.barcode.auth;

import com.barcode.server.barcode.dao.User;
import com.barcode.server.barcode.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * PackageName : com.barcode.server.barcode.auth
 * FileName : UserDetailServiceImpl
 * Author : 이 수 경
 * Date : 2022-08-15
 * Description :
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
        System.out.println(userRepository);
        System.out.println(userRepository.findByEmail(email));
        User user = userRepository.findByEmail(email).get();
        if(user == null) {
            throw new UsernameNotFoundException("Can't find"+email);
        }
        return CustomUserDetails.builder().username(user.getEmail()).password(user.getPassword()).authorities(getAuthorities(email)).build() ;
    }

    public Collection<GrantedAuthority> getAuthorities(String email) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(userRepository.findByEmail(email).get().getRole().toString()));
        return authorities;
    }
}


