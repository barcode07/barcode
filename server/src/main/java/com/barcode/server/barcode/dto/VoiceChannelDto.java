package com.barcode.server.barcode.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotEmpty;

/**
 * PackageName : com.barcode.server.barcode.dto
 * FileName : VoiceChannelDto
 * Author : 이 수 경
 * Date : 2022-08-21
 * Description :
 */
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@ToString
public class VoiceChannelDto {

    @NotEmpty
    @Schema(type="integer", format = "int64", description = "채널 그룹 ID", nullable = false, example = "1")
    private Long channelGroupId;

    @NotEmpty
    @Schema(type="string", description = "음성 채널 이름", nullable = false, example = "1")
    private String name;
}
