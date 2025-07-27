package com.example.appcenter_project.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Value("${app.urls.production}")
    private String productionUrl;

    @Value("${app.urls.development}")
    private String developmentUrl;

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws-stomp")
                .setAllowedOriginPatterns("http://localhost:*", "https://localhost:*")
                .setAllowedOrigins(productionUrl, developmentUrl);
                // .withSockJS(); // SockJS 제거하여 순수 WebSocket 허용
                
        // SockJS도 함께 지원하려면 별도 엔드포인트 추가
        registry.addEndpoint("/ws-stomp-sockjs")
                .setAllowedOriginPatterns("http://localhost:*", "https://localhost:*")
                .setAllowedOrigins(productionUrl, developmentUrl)
                .withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/sub");
        registry.setApplicationDestinationPrefixes("/pub");
    }
}
