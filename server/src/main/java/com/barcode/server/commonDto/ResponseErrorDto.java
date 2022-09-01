package com.barcode.server.commonDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


/**
 * PackageName : com.example.ssssksss_blog.commonDto
 * FileName : ResponseErrorDto
 * Author : 이 수 경
 * Date : 2022-04-22
 * Description :
 */

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseErrorDto {

    private static final long serialVersionUID = 1L;

    private int statusCode;
    private String msg;
}
