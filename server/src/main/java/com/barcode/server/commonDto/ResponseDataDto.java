package com.barcode.server.commonDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDataDto {

    private static final long serialVersionUID = 1L;

    private int statusCode;
    private String msg;
    private HashMap<String,Object> data;
    @Builder.Default private Boolean successFlag = true;

    public ResponseDataDto(int statusCode, String msg, HashMap<String, Object> data) {
        this.statusCode = statusCode;
        this.msg = msg;
        this.data = data;
    }
}
