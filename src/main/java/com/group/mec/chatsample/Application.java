package com.group.mec.chatsample;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.group.mec.chatsample.model.Login;
import com.group.mec.chatsample.model.Message;
import com.group.mec.chatsample.service.ChatService;
import com.group.mec.chatsample.service.UserService;
/**
 * 
 * @author memrecaglan
 *
 */
@SpringBootApplication
@EnableAutoConfiguration
public class Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner messageRunner(ChatService chatService){
		return args -> {
			chatService.save( new Message(1L,"Create Spring Boot Application", new Date(), "emre") );
			chatService.save( new Message(2L,"Create Spring Project Packages", new Date(), "mem") );
			chatService.save( new Message(3L,"Create the Task Domain Class", new Date(), "fff") );
			chatService.save( new Message(4L,"Create service and repository classes", new Date(), "aaaa") );
			chatService.save( new Message(5L,"Create the command line runner to load data", new Date(), "dddd") );
		};
	}
	
	@Bean
	CommandLineRunner loginRunner(UserService userService){
		return args -> {
			userService.save( new Login(1L,"mec", new Date(), "murt") );
			userService.save( new Login(2L,"spring", new Date(), "mem") );
			userService.save( new Login(3L,"wolwerine", new Date(), "fff") );
			userService.save( new Login(4L,"chat", new Date(), "aaaa") );
			userService.save( new Login(5L,"data", new Date(), "dddd") );
		};
	}
}