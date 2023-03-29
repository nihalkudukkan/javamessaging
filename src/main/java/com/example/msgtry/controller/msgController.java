package com.example.msgtry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.msgtry.pojos.Employee;
import com.example.msgtry.service.MessageService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class msgController {
	@Autowired
	ObjectMapper mapper;
	
	@Autowired
	private MessageService msgService;
	
	@PostMapping("/emp")
	public String addEmp(@RequestBody Employee employee) throws JsonProcessingException {
		msgService.send(mapper.writeValueAsString(employee));
		return "added";
	}
}
