package com.barcode.server.config;

import com.barcode.server.barcode.handler.SocketTextHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

/**
 * PackageName : com.barcode.server.config
 * FileName : WebSocketConfig
 * Author : 이 수 경
 * Date : 2022-09-02
 * Description :
 */

@Configuration
@EnableWebSocketMessageBroker
// 소켓 통신 설정
public class WebSocketStompConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
//        접속 경로 명시, SockJS으로 소켓 작업
        registry.addEndpoint("/webSocket").setAllowedOrigins("http://localhost:3000").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
//        react와 통신하므로 cross origin문제가 발생
        registry.enableSimpleBroker("/topic","/queue");
        registry.setApplicationDestinationPrefixes("/");

    }
}