package com.group.mec.chatsample.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.group.mec.chatsample.model.Login;
/**
 * 
 * @author memrecaglan
 *
 */
@Repository
public class ParticipantRepository {

	private Map<String, Login> activeSessions = new HashMap<>();

	public void add(String sessionId, Login event) {
		activeSessions.put(sessionId, event);
	}

	public Login getParticipant(String sessionId) {
		return activeSessions.get(sessionId);
	}

	public void removeParticipant(String sessionId) {
		activeSessions.remove(sessionId);
	}

	public Map<String, Login> getActiveSessions() {
		return activeSessions;
	}

	public void setActiveSessions(Map<String, Login> activeSessions) {
		this.activeSessions = activeSessions;
	}
}
