package com.threec.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.threec.beans.Consumer;
import com.threec.service.ConsumerService;

@RestController
@CrossOrigin("*")
@RequestMapping("/consumer")
public class ConsumerController {

	@Autowired
	ConsumerService consumerService;
	
	// REGISTER A NEW CONSUMER
	@PostMapping("/consumer")
	public ResponseEntity<Consumer> register(@RequestBody Consumer consumer){
		Consumer registered=consumerService.register(consumer);
		if(registered!=null) return ResponseEntity.ok(registered);
		return new ResponseEntity<Consumer>(HttpStatus.BAD_REQUEST);
	}
	
	// RETRIEVE ONE CONSUMER
	@GetMapping("/consumers/{consumerId}")
	public ResponseEntity<Consumer> getOne(@PathVariable int consumerId){
		Consumer found=consumerService.findByConsumerId(consumerId);
		if(found==null) return new ResponseEntity<Consumer>(HttpStatus.NOT_FOUND);
		return ResponseEntity.ok(found);
	}

	// RETRIEVE ALL CONSUMERS
	@GetMapping("/consumers")
 	public ResponseEntity<List<Consumer>> getAll(){
		List<Consumer> clist= consumerService.getAll();
		return ResponseEntity.ok(clist);
	}
	
	// SAY HELLO
	@GetMapping("/hello")
	public ResponseEntity<String> sayHello(){
		return ResponseEntity.ok("Hello, you have a token");
	}
	
	
}
