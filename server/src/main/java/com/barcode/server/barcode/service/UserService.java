package com.barcode.server.barcode.service;

import com.barcode.server.barcode.dao.User;
import com.barcode.server.barcode.dto.TokenDto;
import com.barcode.server.barcode.dto.UserLoginDto;
import com.barcode.server.barcode.dto.UserSignupDto;
import com.barcode.server.barcode.repository.UserRepository;
import com.barcode.server.commonDto.ResponseDataDto;
import com.barcode.server.commonDto.ResponseErrorDto;
import com.barcode.server.commonDto.ResponseErrorsDto;
import com.barcode.server.commonDto.ResponseStatusDto;
import com.barcode.server.jwt.JwtTokenManager;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * PackageName : com.example.ssssksss_blog.blog.service
 * FileName : UserService
 * Author : 이 수 경
 * Date : 2022-04-03
 * Description :
 */
@Service
public class UserService {

    @Value("${jwt.jwtSecret}")
    public static String jwtSecret;

    @Value("${domain.cookie}")
    public static String domainCookie;

//    private String domain = "ssssksss.xyz";
    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private JwtTokenManager jwtTokenManager;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, JwtTokenManager jwtTokenManager) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.jwtTokenManager = jwtTokenManager;
    }

    public ResponseEntity validateSignupParameter(BindingResult bindingResult) {
        HashMap<String,Object> errorMap = new HashMap<>();
                for(FieldError fieldError: bindingResult.getFieldErrors()) {
            errorMap.put(fieldError.getField(),fieldError.getDefaultMessage());
        }
        return ResponseEntity.badRequest()
                .body(new ResponseErrorsDto(400,errorMap));
    }

    public ResponseEntity validateLoginParameter(Errors errors) {
        HashMap<String,Object> errorMap = new HashMap<>();
        for(FieldError fieldError: errors.getFieldErrors()) {
            errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return ResponseEntity.badRequest()
                .body(new ResponseErrorsDto(400,errorMap));
    }

    public ResponseEntity signup(UserSignupDto userSignupDto) {
        if(userRepository.existsByEmail(userSignupDto.getEmail())) {
            return ResponseEntity.badRequest()
                    .body(new ResponseErrorDto(400,"중복된 이메일이 존재합니다."));
        }else if(userRepository.existsByNickname(userSignupDto.getNickname())) {
            return ResponseEntity.badRequest()
                    .body(new ResponseErrorDto(400,"중복된 닉네임이 존재합니다."));
        }
        userRepository.save(User.builder()
                .password(bCryptPasswordEncoder.encode(userSignupDto.getPassword()))
                .nickname(userSignupDto.getNickname())
                .email(userSignupDto.getEmail()).build());
        return ResponseEntity.ok().body(new ResponseStatusDto(200,"회원가입 성공"));
    }
}


