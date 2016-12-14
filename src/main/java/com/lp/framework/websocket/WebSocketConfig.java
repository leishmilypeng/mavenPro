package com.lp.framework.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.standard.ServletServerContainerFactoryBean;

import com.lp.framework.intercepter.HandshakeInterceptor;
import com.lp.framework.handler.MyHandler;

@Configuration
@EnableWebMvc
@EnableWebSocket	//开启websocket
public class WebSocketConfig implements WebSocketConfigurer  {

    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(new MyHandler(),"/echo").addInterceptors(new HandshakeInterceptor()); //支持websocket 的访问链接
        registry.addHandler(new MyHandler(),"/sockjs/echo").addInterceptors(new HandshakeInterceptor()).withSockJS(); //不支持websocket的访问链接
    }
	
	/*
	 *  Configuring the WebSocket Engine
	 */
	@Bean
    public ServletServerContainerFactoryBean createWebSocketContainer() {
        ServletServerContainerFactoryBean container = new ServletServerContainerFactoryBean();
        container.setMaxTextMessageBufferSize(8192);
        container.setMaxBinaryMessageBufferSize(8192);
        return container;
    }
	
	/*
	 * All transport requests have the following URL structure:
	 * http://host:port/myApp/myEndpoint/{server-id}/{session-id}/{transport}
	 */
	
}
