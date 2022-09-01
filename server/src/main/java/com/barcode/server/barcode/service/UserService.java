package com.barcode.server.barcode.service;

import com.barcode.server.barcode.dao.Role;
import com.barcode.server.barcode.dao.User;
import com.barcode.server.barcode.dto.UserLoginDto;
import com.barcode.server.barcode.dto.UserSignupDto;
import com.barcode.server.barcode.repository.UserRepository;
import com.barcode.server.commonDto.ResponseErrorDto;
import com.barcode.server.commonDto.ResponseErrorsDto;
import com.barcode.server.commonDto.ResponseStatusDto;
import com.barcode.server.commonDto.ResponseTokenDto;
import com.barcode.server.jwt.JwtTokenManager;
import io.jsonwebtoken.Claims;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import javax.servlet.http.HttpServletRequest;
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

//    @Value("${jwt.jwtSecret}")
//    public static String jwtSecret;
//
//    @Value("${domain.cookie}")
//    public static String domainCookie;

//    private String domain = "ssssksss.xyz";
    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private JwtTokenManager jwtTokenManager;
    private AuthenticationManager authenticationManager;

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

    @Transactional
    public ResponseEntity login(UserLoginDto userLoginDto, HttpServletResponse response){
        try {
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(userLoginDto.getEmail(), userLoginDto.getPassword()));
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//            UserDetailsImpl principal = (UserDetailsImpl) authentication.getPrincipal();
//            return principal.getUsername();
        User user = userRepository.findByEmail(userLoginDto.getEmail()).get();
            if (user.getEmail() == null) {
                return ResponseEntity.badRequest()
                        .body(new ResponseErrorDto(400, "존재하지 않는 이메일 입니다."));
            } else if (!bCryptPasswordEncoder.matches(userLoginDto.getPassword(), user.getPassword())) {
                return ResponseEntity.badRequest()
                        .body(new ResponseErrorDto(400, "비밀번호가 일치하지 않습니다."));
            }
            String accessToken = jwtTokenManager.createAccessToken(user);
            jwtTokenManager.createRefreshToken(user, response);


        return ResponseEntity.ok().body(new ResponseTokenDto(200,"로그인이 성공적으로 되었습니다.",accessToken));
        } catch(Exception e) {
            return ResponseEntity.badRequest()
                    .body(new ResponseErrorDto(400,"잘못되었습니다."));
        }
    }

    public ResponseEntity logout(HttpServletResponse response) {
        jwtTokenManager.deleteRefreshToken(response);
        return ResponseEntity.ok().body(new ResponseStatusDto(200,"성공적으로 로그아웃이 되었습니다."));
    }


    public ResponseEntity updateAccessToken(HttpServletRequest request) {
//        System.out.println("========================================");
//        System.out.println(request.getCookies()[0].getName());
//        System.out.println(request.getCookies()[0].getValue());
        String refreshToken = request.getCookies()[0].getValue();
        Claims claims = jwtTokenManager.validRefreshTokenAndReturnBody(refreshToken);
        System.out.println(claims);
        System.out.println(claims.get("email"));
        System.out.println(claims.get("role"));
//        System.out.println(jwtTokenManager.createAccessToken(User.builder()
//                .email((String)claims.get("email")).role(Role.valueOf((String)claims.get("role"))).build()));
        String newAccessToken = jwtTokenManager.createAccessToken(User.builder()
                .email((String)claims.get("email")).role(Role.valueOf((String)claims.get("role"))).build());
//        System.out.println(newAccessToken.toString());
//        System.out.println("========================================");
        return ResponseEntity.ok().body(new ResponseTokenDto(200,"정상적으로 다시 액세스 토큰이 발급되었습니다.",newAccessToken));
    }

    public ResponseEntity userTest(HttpServletRequest request) {
        return ResponseEntity.status(200).body(new ResponseStatusDto(200,"성공"));
    }
}


