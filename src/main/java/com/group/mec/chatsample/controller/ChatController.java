package com.group.mec.chatsample.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;

import com.group.mec.chatsample.model.Login;
import com.group.mec.chatsample.model.Message;
import com.group.mec.chatsample.service.ChatService;
import com.group.mec.chatsample.service.ParticipantService;

/**
 * 
 * @author memrecaglan
 *
 */
@Controller
public class ChatController {

	private Logger logger = LoggerFactory.getLogger(ChatController.class);

	@Autowired
	private ParticipantService participantService;
	
	@Autowired
	private ChatService chatService;

	@SubscribeMapping("/chat.history")
	public Collection<Message> historyMessages(Principal principal) {
		List<Message> messages = new ArrayList<>();
		for (Message message : chatService.getAllMessages()) {
			messages.add(message);
		}
		logger.info(messages.toString());
		return messages;
	}

	@SubscribeMapping("/chat.participants")
	public Collection<Login> retrieveParticipants() {
		return participantService.getActiveSessions().values();
	}

	@MessageMapping("/chat.message")
	public Message filterMessage(@Payload Message message, Principal principal) {
		message.setUsername(principal.getName());
		message.setMessageDate(new Date());
		chatService.save(message);
		return message;
	}

}
