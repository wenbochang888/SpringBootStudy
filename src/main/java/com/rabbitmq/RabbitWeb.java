package com.rabbitmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class RabbitWeb {
	
	@Autowired
	RabbitSender sender;
	
	@RequestMapping(value = "/rabbit/send", method = RequestMethod.GET)
	public void send(@Param("username") String username,
			@Param("password") String password) throws JsonProcessingException {
		
		Object user = new User(username, password);
		ObjectMapper mapper = new ObjectMapper();
		sender.send(mapper.writeValueAsString(user));
	}
}













