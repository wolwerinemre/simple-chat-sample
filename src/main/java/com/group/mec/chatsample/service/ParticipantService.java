package com.group.mec.chatsample.service;

import java.util.Map;

import com.group.mec.chatsample.model.Login;
/**
 * 
 * @author memrecaglan
 *
 */
public interface ParticipantService {
	
	public void add(String sessionId, Login event) ;

	public Login getParticipant(String sessionId) ;

	public void removeParticipant(String sessionId) ;

	public Map<String, Login> getActiveSessions() ;

	public void setActiveSessions(Map<String, Login> activeSessions) ;

}
