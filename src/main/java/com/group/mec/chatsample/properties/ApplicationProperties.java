package com.group.mec.chatsample.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "simpleChat")
public class ApplicationProperties {
	
	private String loginDestination;
	private String logoutDestination;
	
	public String getLoginDestination() {
		return loginDestination;
	}
	public void setLoginDestination(String loginDestination) {
		this.loginDestination = loginDestination;
	}
	public String getLogoutDestination() {
		return logoutDestination;
	}
	public void setLogoutDestination(String logoutDestination) {
		this.logoutDestination = logoutDestination;
	}
	
	

}
