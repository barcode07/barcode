package com.barcode.server.barcode.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * PackageName : com.barcode.server.barcode.dto
 * FileName : MessageDto
 * Author : 이 수 경
 * Date : 2022-08-28
 * Description :
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MessageDto {

    private String username;
    private String content;
    private LocalDateTime date;

}