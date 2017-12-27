package com.group.mec.chatsample.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.group.mec.chatsample.model.Login;
/**
 * 
 * @author memrecaglan
 *
 */
@Repository
public interface UserRepository extends CrudRepository<Login,Long> {
	
	

}
