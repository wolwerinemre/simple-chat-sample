package com.group.mec.chatsample.eventlistener;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.util.ObjectUtils;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import com.group.mec.chatsample.model.Login;
import com.group.mec.chatsample.service.ParticipantService;
/**
 * 
 * @author memrecaglan
 *
 */
public class PresenceEventListener {
	
	@Autowired
	private ParticipantService participantService;
	
	private SimpMessagingTemplate messagingTemplate;
	
	private String loginDestination;
	
	private String logoutDestination;
	
	public PresenceEventListener(SimpMessagingTemplate messagingTemplate) {
		this.messagingTemplate = messagingTemplate;
	}
		
	@EventListener
	private void handleSessionConnected(SessionConnectEvent event) {
		SimpMessageHeaderAccessor headers = SimpMessageHeaderAccessor.wrap(event.getMessage());
		String username = headers.getUser().getName();

		Login login = new Login();
		login.setUsername(username);
		messagingTemplate.convertAndSend(loginDestination, login);
		
		// We have same sessionId do not add
		// We store the session as we need to be idempotent in the disconnect event processing
		if(controlParticipant(headers.getSessionId())) {
			participantService.add(headers.getSessionId(), login);			
		}
	}
	
	private boolean controlParticipant(String sessionId) {
		System.out.println(participantService.getActiveSessions());
		return ObjectUtils.isEmpty(participantService.getParticipant(sessionId)) ? true : false;
	}

	@EventListener
	private void handleSessionDisconnect(SessionDisconnectEvent event) {
		Optional.ofNullable(participantService.getParticipant(event.getSessionId()))
				.ifPresent(login -> {
					messagingTemplate.convertAndSend(logoutDestination, login.getUsername());
					participantService.removeParticipant(event.getSessionId());
				});
	}

	public void setLoginDestination(String loginDestination) {
		this.loginDestination = loginDestination;
	}

	public void setLogoutDestination(String logoutDestination) {
		this.logoutDestination = logoutDestination;
	}
}
