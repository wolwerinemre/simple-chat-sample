package com.group.mec.chatsample.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import com.group.mec.chatsample.eventlistener.PresenceEventListener;
import com.group.mec.chatsample.properties.ApplicationProperties;
/**
 * 
 * @author memrecaglan
 *
 */
@Configuration
@EnableConfigurationProperties(ApplicationProperties.class)
public class ChatConfiguration {

	@Autowired
	private ApplicationProperties applicationProperties;
	
	@Bean
	@Description("Tracks user presence (join / leave) and broacasts it to all connected users")
	public PresenceEventListener presenceEventListener(SimpMessagingTemplate messagingTemplate) {
		PresenceEventListener presence = new PresenceEventListener(messagingTemplate);
		presence.setLoginDestination(applicationProperties.getLoginDestination());
		presence.setLogoutDestination(applicationProperties.getLogoutDestination());
		return presence;
	}

}
