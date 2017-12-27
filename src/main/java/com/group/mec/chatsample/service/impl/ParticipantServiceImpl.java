package com.group.mec.chatsample.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.mec.chatsample.model.Login;
import com.group.mec.chatsample.repository.ParticipantRepository;
import com.group.mec.chatsample.service.ParticipantService;
/**
 * 
 * @author memrecaglan
 *
 */
@Service
public class ParticipantServiceImpl implements ParticipantService{
	
	@Autowired
	private ParticipantRepository participantRepository;

	@Override
	public void add(String sessionId, Login event) {
		participantRepository.add(sessionId, event);
	}

	@Override
	public Login getParticipant(String sessionId) {
		return participantRepository.getParticipant(sessionId);
	}

	@Override
	public void removeParticipant(String sessionId) {
		participantRepository.removeParticipant(sessionId);
		
	}

	@Override
	public Map<String, Login> getActiveSessions() {
		return participantRepository.getActiveSessions();
	}

	@Override
	public void setActiveSessions(Map<String, Login> activeSessions) {
		participantRepository.setActiveSessions(activeSessions);
	}

}
