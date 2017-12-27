package com.group.mec.chatsample.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.messaging.MessageSecurityMetadataSourceRegistry;
import org.springframework.security.config.annotation.web.socket.AbstractSecurityWebSocketMessageBrokerConfigurer;
/**
 * 
 * @author memrecaglan
 *
 */
@Configuration
public class WebSocketSecurityConfiguration extends AbstractSecurityWebSocketMessageBrokerConfigurer {

	@Override
	protected void configureInbound(MessageSecurityMetadataSourceRegistry messages) {
		messages
				// only the application can send to these broker destinations,
		 		.simpMessageDestMatchers("/topic/chat.login", "/topic/chat.logout", "/topic/chat.message","/topic/chat.history").denyAll()
				.anyMessage().authenticated();
	}

	@Override
	protected boolean sameOriginDisabled() {
		//disable CSRF for websockets for now...
		return true;
	}
}