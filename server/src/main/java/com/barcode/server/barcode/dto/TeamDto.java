package com.barcode.server.barcode.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotEmpty;

/**
 * PackageName : com.barcode.server.barcode.dto
 * FileName : TeamDto
 * Author : 이 수 경
 * Date : 2022-08-19
 * Description :
 */
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@ToString
public class TeamDto {

    @NotEmpty
    @Schema(type="integer", format = "int64", description = "", nullable = false, example = "1")
    private Long userId;

    @NotEmpty
    @Schema(type="integer", format = "int64", description = "", nullable = false, example = "1")
    private Long serverId;
}
