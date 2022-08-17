package com.barcode.server.barcode.controller;
import com.barcode.server.barcode.dto.UserLoginDto;
import com.barcode.server.barcode.dto.UserSignupDto;
import com.barcode.server.barcode.service.UserService;
import com.barcode.server.commonDto.ResponseDataDto;
import com.barcode.server.commonDto.ResponseErrorDto;
import com.barcode.server.commonDto.ResponseStatusDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
//@Tag(name="유저", description = "유저 API")
//@ApiResponses({
//        @ApiResponse(responseCode = "200", description = "성공"),
//        @ApiResponse(responseCode = "400", description = "잘못된 요청"),
//        @ApiResponse(responseCode = "404", description = "잘못된 접근입니다."),
//        @ApiResponse(responseCode = "500", description = "서버 에러"),
//})
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


}

