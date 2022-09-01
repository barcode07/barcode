package com.barcode.server.barcode.controller;

import com.barcode.server.barcode.dto.MessageDto;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

/**
 * PackageName : com.barcode.server.barcode.controller
 * FileName : ChatController
 * Author : 이 수 경
 * Date : 2022-08-28
 * Description :
 */
@RestController
public class ChatController {

    // /hello 경로로 받은 메시지를 받고
    // /topic/roomId로 메시지를 분배한다.
    @MessageMapping("/hello")
    @SendTo("/topic/roomId")
    public MessageDto boradCast(MessageDto message){
        return message;
    }
}