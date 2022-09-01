package com.barcode.server.barcode.controller;

import com.barcode.server.barcode.dto.VoiceChannelDto;
import com.barcode.server.barcode.service.VoiceChannelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * PackageName : com.barcode.server.barcode.controller
 * FileName : VoiceChannelController
 * Author : 이 수 경
 * Date : 2022-08-21
 * Description :
 */

@RestController
@RequiredArgsConstructor
@Api(value="음성 채널 API", tags="Voice Channel API")
public class VoiceChannelController {

    private final VoiceChannelService voiceChannelService;

    @ApiOperation(value = "음성 채널 생성", notes="음성 채널을 생성한다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = ResponseEntity.class ))),
            @ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content(schema = @Schema(implementation = ResponseEntity.class ))),
            @ApiResponse(responseCode = "404", description = "잘못된 접근입니다."),
            @ApiResponse(responseCode = "500", description = "서버 에러"),
    })
    @RequestMapping(value="/api/voice-channel", method= RequestMethod.POST)
    public  ResponseEntity voiceChannelCreate(@RequestBody VoiceChannelDto voiceChannelDto) {
        return voiceChannelService.create(voiceChannelDto);
    }

    @ApiOperation(value = "음성 채널방 들어가기", notes="음성 채널을 들어가기")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = ResponseEntity.class ))),
            @ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content(schema = @Schema(implementation = ResponseEntity.class ))),
            @ApiResponse(responseCode = "404", description = "잘못된 접근입니다."),
            @ApiResponse(responseCode = "500", description = "서버 에러"),
    })
    @RequestMapping(value="/api/voice-channel", method= RequestMethod.GET)
    public  ResponseEntity voiceChannelRead(@ApiParam(name="voiceChannelId", type="integer", format = "int64", value = "1",example = "1", required = true) @RequestParam Long voiceChannelId) {
        return voiceChannelService.read(voiceChannelId);
    }
}



