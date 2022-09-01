package com.barcode.server.barcode.controller;

import com.barcode.server.barcode.dto.ChannelGroupDto;
import com.barcode.server.barcode.service.ChannelGroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * PackageName : com.barcode.server.barcode.controller
 * FileName : UserGroupController
 * Author : 이 수 경
 * Date : 2022-08-21
 * Description :
 */

@RestController
@RequiredArgsConstructor
@Api(value="채널그룹 API", tags="Channel API")
// 나중에 ChannelGroupController로 변경할것
public class ChannelGroupController {

    private final ChannelGroupService channelGroupService;

    @ApiOperation(value = "채널 생성", notes="채널을 생성한다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = ResponseEntity.class ))),
            @ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content(schema = @Schema(implementation = ResponseEntity.class ))),
            @ApiResponse(responseCode = "404", description = "잘못된 접근입니다."),
            @ApiResponse(responseCode = "500", description = "서버 에러"),
    })
    @RequestMapping(value="/api/channel-group", method= RequestMethod.POST)
    public  ResponseEntity createChannelGroup(@RequestBody ChannelGroupDto channelGroupDto) {

        return channelGroupService.create(channelGroupDto);
    }

}
