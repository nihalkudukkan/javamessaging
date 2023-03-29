package com.example.msgtry.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import com.example.msgtry.pojos.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class MessageListener {
	@Autowired
	ObjectMapper mapper;
	
	@JmsListener(destination = "msgtry")
	public void getMessage(String message,
			@Header(name = "check") String check,
			MessageHeaders messageHeaders) throws JsonMappingException, JsonProcessingException {
		log.info("Message property check = {}", check);
		log.info("Message Headers = {}", messageHeaders);
		System.out.println("Employee received is: " + message);
		Employee employee = mapper.readValue(message, Employee.class);
		System.out.println("Employee name: " + employee.getName());
	}
}
