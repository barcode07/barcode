package com.barcode.server.barcode.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotEmpty;


/**
 * PackageName : com.barcode.server.barcode.dto.server
 * FileName : serverDto
 * Author : 이 수 경
 * Date : 2022-08-19
 * Description :
 */
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@ToString
public class ServerDto {

    private static final long serialVersionUID = 1L;

    @NotEmpty
    @Schema(type="integer", format = "int64", description = "", nullable = false, example = "1")
    private Long userId;

    @NotEmpty
    @Schema(type="string", description = "서버이름", nullable = false, example = "호그와트")
    private String name;

}
