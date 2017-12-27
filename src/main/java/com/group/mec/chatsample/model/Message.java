package com.group.mec.chatsample.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author memrecaglan
 *
 */
@Entity
@Table(name = "MESSAGES")
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotNull
	private String username;
	@NotNull
	private String message;
	private Date messageDate;

	public Message() {
		super();
	}

	public Message(long id, String string, Date now, String username) {
		super();
		this.id = id;
		this.username = username;
		this.messageDate = now;
		this.message = string;

	}

	public Date getMessageDate() {
		return messageDate;
	}

	public void setMessageDate(Date messageDate) {
		this.messageDate = messageDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", username=" + username + ", message=" + message + ", messageDate=" + messageDate
				+ "]";
	}

}
