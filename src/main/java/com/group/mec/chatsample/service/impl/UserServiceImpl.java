package com.group.mec.chatsample.service.impl;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.mec.chatsample.model.Login;
import com.group.mec.chatsample.repository.UserRepository;
import com.group.mec.chatsample.service.UserService;
/**
 * 
 * @author memrecaglan
 *
 */
@Service
public class UserServiceImpl implements UserService {
	
	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
    private UserRepository userRepository;

	@Override
	public Iterable<Login> getAllUsers() {
		logger.info(userRepository.findAll().toString());
        return userRepository.findAll();
    }
	
	@Override
	public Login getUser(String username,String password) {
		for (Login userLogin : userRepository.findAll()) {
			if( userLogin.getUsername().equals(username) && userLogin.getPassword().equals(password)) {
					logger.info(userLogin.toString());
					return userLogin;
			}
		}
		logger.info("User not found");
        return null;
    }
	
    @Override
    @Transactional
    public Login save(Login login) {
    		logger.info(login.toString());
        return userRepository.save(login);
    }

}
