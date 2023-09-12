package com.sspamqe.websocket;


import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/output");//destination for client subscription
        config.setApplicationDestinationPrefixes("/input");//message receiver destination
    }

    @Override //user should connect to this endpoint
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/robotCommander");
    }

}
