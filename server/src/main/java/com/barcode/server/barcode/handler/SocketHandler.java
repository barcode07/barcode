package com.barcode.server.barcode.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * PackageName : com.barcode.server.barcode.handler
 * FileName : SocketHandler
 * Author : 이 수 경
 * Date : 2022-08-23
 * Description :
 */
@Component
public class SocketHandler extends TextWebSocketHandler {

    // WebSocketSession을 콜렉션으로 관리를 해준다.
    List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();

    // 연결후 세션을 추가해주고
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessions.add(session);
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message)
            throws InterruptedException, IOException {
        for (WebSocketSession webSocketSession : sessions) {
            if (webSocketSession.isOpen() && !session.getId().equals(webSocketSession.getId())) {
                webSocketSession.sendMessage(message);
            }
        }
    }

    //    연결을 끊을 때 세션에서 제거해준다.
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessions.remove(session);
        super.afterConnectionClosed(session, status);
    }
}