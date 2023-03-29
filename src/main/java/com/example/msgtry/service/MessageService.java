package com.example.msgtry.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.example.msgtry.pojos.Employee;

@Service
public class MessageService {
	private static final String QUEUE = "msgtry";
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	public void send(String msg) {
		jmsTemplate.convertAndSend(QUEUE, msg, (message) -> {
			message.setStringProperty("check", "nihal");
			return message;
		});
	}
}
