package com.group.mec.chatsample.service;

import com.group.mec.chatsample.model.Login;
/**
 * 
 * @author memrecaglan
 *
 */
public interface UserService {

	public Iterable<Login> getAllUsers();

	public Login save(Login login);

	public Login getUser(String username, String password);

}
