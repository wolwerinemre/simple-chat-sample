package com.group.mec.chatsample.service;

import com.group.mec.chatsample.model.Message;
/**
 * 
 * @author memrecaglan
 *
 */
public interface ChatService {

	public Iterable<Message> getAllMessages();

	public Message save(Message message);

}
