package com.barcode.server.barcode.controller;

import com.barcode.server.barcode.dto.ServerDto;
import com.barcode.server.barcode.service.ServerService;
import com.barcode.server.commonDto.ResponseErrorDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


/**
 * PackageName : com.barcode.server.barcode.controller
 * FileName : ServerController
 * Author : 이 수 경
 * Date : 2022-08-19
 * Description :
 */
@RestController
@RequiredArgsConstructor
@Api(value="서버 API", tags="Server API")
public class ServerController {

    private final ServerService serverService;

    @ApiOperation(value = "서버생성", notes="서버를 생성한다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = ResponseEntity.class ))),
            @ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content(schema = @Schema(implementation = ResponseEntity.class ))),
            @ApiResponse(responseCode = "404", description = "잘못된 접근입니다."),
            @ApiResponse(responseCode = "500", description = "서버 에러"),
    })
    @RequestMapping(value="/barcode/server", method= RequestMethod.POST)
    public ResponseEntity createServer(@RequestBody ServerDto serverDto) {
        return serverService.create(serverDto);
    }

    @ApiOperation(value = "서버 조회", notes="서버를 조회한다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = ResponseEntity.class ))),
            @ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content(schema = @Schema(implementation = ResponseEntity.class ))),
            @ApiResponse(responseCode = "404", description = "잘못된 접근입니다."),
            @ApiResponse(responseCode = "500", description = "서버 에러"),
    })
    @RequestMapping(value="/barcode/server", method= RequestMethod.GET)
    public ResponseEntity readServer() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal == null) {
            ResponseEntity.ok()
                    .body(ResponseErrorDto.builder().statusCode(401).msg("로그인이 필요합니다.").build());

        }
        return serverService.read((String)principal);
    }

    @ApiOperation(value = "서버삭제", notes="서버를 삭제한다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = ResponseEntity.class ))),
            @ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content(schema = @Schema(implementation = ResponseEntity.class ))),
            @ApiResponse(responseCode = "404", description = "잘못된 접근입니다."),
            @ApiResponse(responseCode = "500", description = "서버 에러"),
    })
    @RequestMapping(value="/barcode/server", method= RequestMethod.DELETE)
    public ResponseEntity deleteServer(
//            @Schema(type="string", description = "", nullable = false, example = "1") String serverId) {
            @ApiParam(name="serverId", type="string", value = "1",example = "1", required = true) @RequestParam String serverId) {
        return serverService.delete(Long.valueOf(serverId));
    }
}
