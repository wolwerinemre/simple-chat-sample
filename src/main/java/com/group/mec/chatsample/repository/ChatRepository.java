package com.group.mec.chatsample.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.group.mec.chatsample.model.Message;
/**
 * 
 * @author memrecaglan
 *
 */
@Repository
public interface ChatRepository extends CrudRepository<Message,Long> {

}
