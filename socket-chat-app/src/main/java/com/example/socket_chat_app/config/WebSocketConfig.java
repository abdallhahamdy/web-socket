package com.example.socket_chat_app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
//WebSocketMessageBrokerConfigurer: Interface for connect with server to establish connection.
//@EnableWebSocketMessageBroker: Annotation to allow WS implement to WebSocketMessageBrokerConfigurer.
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    // registerStompEndpoints to select URL to connect with server.
    // STOMP: Streaming Text Messaging Protocol.
    // STOMP: exchange and transfer data.
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/connect").setAllowedOriginPatterns("*").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic");
        registry.setApplicationDestinationPrefixes("/app");
    }

    /* Note: WebSocket just open connection between client side and server side
             WebSocket can not define roles or users or transfer data
     */
}
