package com.barcode.server.barcode.controller;

<<<<<<< HEAD
import com.barcode.server.barcode.service.TeamService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
=======
import com.barcode.server.barcode.dto.TeamDto;
import com.barcode.server.barcode.dto.UserSignupDto;
import com.barcode.server.barcode.service.TeamService;
import com.barcode.server.barcode.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
>>>>>>> 1c7d14314658c1a463824e558e22bced466a0aee

/**
 * PackageName : com.barcode.server.barcode.controller
 * FileName : TeamController
 * Author : 이 수 경
 * Date : 2022-08-19
 * Description :
 */

@RestController
@RequiredArgsConstructor
@Api(value="팀 API", tags="Team API")
public class TeamController {

    private final TeamService teamService ;
//
//    @ApiOperation(value = "팀 생성", notes="서버에 유저를 추가한다.")
//    @ApiResponses({
//            @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = ResponseEntity.class ))),
//            @ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content(schema = @Schema(implementation = ResponseEntity.class ))),
//            @ApiResponse(responseCode = "404", description = "잘못된 접근입니다."),
//            @ApiResponse(responseCode = "500", description = "서버 에러"),
//    })
//    @RequestMapping(value="/user/signup", method= RequestMethod.POST)
//    public  ResponseEntity userSignup(@RequestBody TeamDto teamDto) {
//        return teamService.create(teamDto);
//    }

}
