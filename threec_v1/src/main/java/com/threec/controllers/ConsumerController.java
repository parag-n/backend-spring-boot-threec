package com.threec.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.threec.beans.Consumer;
import com.threec.service.ConsumerService;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

	@Autowired
	ConsumerService consumerService;
	
	// CREATE
	@PostMapping("/consumers")
	public ResponseEntity<Consumer> createConsumer(@RequestBody Consumer consumer){
		Consumer newConsumer=consumerService.createConsumer(consumer);
		return ResponseEntity.ok(newConsumer);
	}
	
	// READ
	
	
	// UPDATE
	
	
	// DELETE
	
}
