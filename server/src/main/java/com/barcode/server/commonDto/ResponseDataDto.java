package com.barcode.server.commonDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Getter
@Builder
@NoArgsConstructor
//@AllArgsConstructor
public class ResponseDataDto<K,T> {

    private static final long serialVersionUID = 1L;

    private int statusCode;
    private String msg;
    private Map<K,T> data;
//    @Builder.Default private Boolean successFlag = true;

    public ResponseDataDto(int statusCode, String msg, Map<K,T> data) {
        this.statusCode = statusCode;
        this.msg = msg;
        this.data = data;
    }
}
