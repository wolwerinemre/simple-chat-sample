package com.group.mec.chatsample.service.impl;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.mec.chatsample.model.Message;
import com.group.mec.chatsample.repository.ChatRepository;
import com.group.mec.chatsample.service.ChatService;
/**
 * 
 * @author memrecaglan
 *
 */
@Service
public class ChatServiceImpl implements ChatService {
	
	private Logger logger = LoggerFactory.getLogger(ChatServiceImpl.class);
	
	@Autowired
    private ChatRepository chatRepository;

	@Override
	public Iterable<Message> getAllMessages() {
		logger.info(chatRepository.findAll().toString());
        return chatRepository.findAll();
    }
    @Override
    @Transactional
    public Message save(Message message) {
    		logger.info(message.toString());
        return chatRepository.save(message);
    }

}
