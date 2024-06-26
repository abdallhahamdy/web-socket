package com.example.socket_chat_app.controller;

import com.example.socket_chat_app.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    // SimpMessageHeaderAccessor: For Adding Users whose login for first time
    // Payload as body
    @MessageMapping("/chat.logIn")
    @SendTo("/topic")
    public ChatMessage login(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor){
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }

    @MessageMapping("/chat.send")
    @SendTo("/topic")
    public ChatMessage send(@Payload ChatMessage chatMessage){
        return chatMessage;
    }
}
