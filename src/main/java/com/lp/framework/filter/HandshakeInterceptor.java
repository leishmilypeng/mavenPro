package com.lp.framework.filter;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;

public class HandshakeInterceptor implements
		org.springframework.web.socket.server.HandshakeInterceptor {

	@Override
	public void afterHandshake(ServerHttpRequest arg0, ServerHttpResponse arg1,
			WebSocketHandler arg2, Exception arg3) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		if (request instanceof ServletServerHttpRequest) {
            ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
            HttpSession session = servletRequest.getServletRequest().getSession(false);
            String userName = "xq";
            if (session != null) {
                //使用userName区分WebSocketHandler，以便定向发送消息
//                String userName = (String) session.getAttribute("WEBSOCKET_USERNAME");
                map.put("WEBSOCKET_USERNAME",userName);
            }
        }
		return false;
	}

}
