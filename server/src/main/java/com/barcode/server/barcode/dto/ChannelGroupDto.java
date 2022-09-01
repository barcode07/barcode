package com.barcode.server.barcode.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotEmpty;

/**
 * PackageName : com.barcode.server.barcode.dto
 * FileName : ChannelGroupDto
 * Author : 이 수 경
 * Date : 2022-08-21
 * Description :
 */

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@ToString
public class ChannelGroupDto {

    private static final long serialVersionUID = 1L;

    @NotEmpty
    @Schema(type="integer", format = "int64", description = "채널그룹이 속한 서버 ID", nullable = false, example = "1")
    private Long serverId;

    @NotEmpty
    @Schema(type="string", description = "채널그룹 이름", nullable = false, example = "음성채팅그룹1")
    private String name;

    @NotEmpty
    @Schema(type="string", description = "채널그룹 타입", nullable = false, example = "VOICE")
    private String type;

}
