package com.barcode.server.barcode.controller;

import com.barcode.server.barcode.dto.MessageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
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

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

//    /hello라는 곳으로 메시지를 받고
    @MessageMapping("/hello/{roomId}")
//    /topic을 구독한 사람들에게 메시지를 리턴할 수 있다.
//    @SendTo("/topic/{roomId}")
    public void broadCast(@DestinationVariable("roomId") String roomId, MessageDto message){
//        System.out.println("방 ID : " + roomId);
//        System.out.println("방 내부 메시지 : " + message);
//        return message;
        simpMessagingTemplate.convertAndSend("/topic/"+roomId, message);
    }
}