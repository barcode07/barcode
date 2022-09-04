package com.barcode.server.barcode.controller;

import com.barcode.server.barcode.dto.UserLoginDto;
import com.barcode.server.barcode.dto.UserSignupDto;
import com.barcode.server.barcode.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * PackageName : com.example.ssssksss_blog.blog.controller
 * FileName : UserController
 * Author : 이 수 경
 * Date : 2022-04-03
 * Description :
 */
@RestController
@RequiredArgsConstructor
@Api(value="유저 API", tags="User API")
public class UserController {

    private final UserService userService;

    @ApiOperation(value = "회원가입", notes="회원가입을 한다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = ResponseEntity.class ))),
            @ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content(schema = @Schema(implementation = ResponseEntity.class ))),
            @ApiResponse(responseCode = "404", description = "잘못된 접근입니다."),
            @ApiResponse(responseCode = "500", description = "서버 에러"),
    })
    @RequestMapping(value="/user/signup", method=RequestMethod.POST)
    public  ResponseEntity userSignup(@Valid @RequestBody UserSignupDto userSignupDto, BindingResult bindingResult) {
        if(bindingResult.getFieldErrorCount()>0) {
            return userService.validateSignupParameter(bindingResult);
        }
        return userService.signup(userSignupDto);
    }

    @ApiOperation(value = "로그인", notes="로그인 API")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = ResponseEntity.class ))),
            @ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content(schema = @Schema(implementation = ResponseEntity.class ))),
            @ApiResponse(responseCode = "404", description = "잘못된 접근입니다."),
            @ApiResponse(responseCode = "500", description = "서버 에러"),
    })
    @RequestMapping(value="/user/login", method=RequestMethod.POST, produces = "application/json; charset=utf-8")
    public ResponseEntity userLogin(@Valid @RequestBody UserLoginDto userLoginDto, BindingResult bindingResult, HttpServletResponse response) {
//        System.out.println(userLoginDto);
        if(bindingResult.getFieldErrorCount()>0) {
            return userService.validateLoginParameter(bindingResult);
        }
        return userService.login(userLoginDto, response);
    }


    @ApiOperation(value = "로그아웃", notes="로그아웃 API")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = ResponseEntity.class ))),
            @ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content(schema = @Schema(implementation = ResponseEntity.class ))),
            @ApiResponse(responseCode = "404", description = "잘못된 접근입니다."),
            @ApiResponse(responseCode = "500", description = "서버 에러"),
    })
    @RequestMapping(value="/user/logout", method=RequestMethod.POST)
    public ResponseEntity userLogout(HttpServletResponse response) {
        return userService.logout(response);
    }
//
//    @RequestMapping(value="/user/test", method=RequestMethod.GET)
//    public String userTest(HttpServletResponse response) {
//        return "테스트 성공";
//    }


    @ApiOperation(value = "리프레쉬 토큰발급", notes="리프레쉬 API")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = ResponseEntity.class ))),
            @ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content(schema = @Schema(implementation = ResponseEntity.class ))),
            @ApiResponse(responseCode = "404", description = "잘못된 접근입니다."),
            @ApiResponse(responseCode = "500", description = "서버 에러"),
    })
    @RequestMapping(value="/user/accessToken", method=RequestMethod.GET)
    public ResponseEntity userReissueAccessToken(HttpServletRequest request) {
        return userService.updateAccessToken(request);
    }

    @ApiOperation(value = "유저 정보 조회", notes="유저 정보 조회 API")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = ResponseEntity.class ))),
            @ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content(schema = @Schema(implementation = ResponseEntity.class ))),
            @ApiResponse(responseCode = "404", description = "잘못된 접근입니다."),
            @ApiResponse(responseCode = "500", description = "서버 에러"),
    })
    @RequestMapping(value="/user", method=RequestMethod.GET)
    public ResponseEntity fetchUser(HttpServletRequest request) {
        return userService.fetchUser(request);
    }


    @RequestMapping(value="/user/test", method=RequestMethod.GET)
    public ResponseEntity userTest(HttpServletRequest request) {
        return userService.userTest(request);
    }

}

