package com.threec.controllers;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;

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

	// READ ONE
	@GetMapping("/consumers/{consumerId}")
	public ResponseEntity<Consumer> readConsumer(@PathVariable int consumerId){
		Consumer returnConsumer=consumerService.readConsumer(consumerId);
		if(returnConsumer!=null) 
			return ResponseEntity.ok(returnConsumer);
		else 
			return new ResponseEntity<Consumer>(HttpStatus.NOT_FOUND);
	}

	// READ ALL
	@GetMapping("/consumers")
	public ResponseEntity<List<Consumer>> readConsumers(){
		List<Consumer> clist=consumerService.readAllConsumers();
		if(clist!=null) 
			return ResponseEntity.ok(clist);
		else 
			return new ResponseEntity<List<Consumer>>(HttpStatus.NOT_FOUND);
	}

	// UPDATE
	@PutMapping("/consumers")
	public ResponseEntity<Consumer> updateConsumer(@RequestBody Consumer consumer){
		Consumer updatedConsumer=consumerService.updateConsumer(consumer);
		if(updatedConsumer!=null) 
			return ResponseEntity.ok(updatedConsumer);
		else 
			return new ResponseEntity<Consumer>(HttpStatus.NOT_FOUND);
	}

	// DELETE
	@DeleteMapping("/consumers/{consumerId}")
	public ResponseEntity<String> deleteConsumer(@PathVariable int consumerId) {
		boolean status=consumerService.deleteConsumer(consumerId);
		if(status) return ResponseEntity.ok("deleted successfully");
		else return new ResponseEntity<String>("uh oh! try again differently!", HttpStatus.BAD_REQUEST);
	}
	
	// LOGIN
	@PostMapping("/login")
	public ResponseEntity<Consumer> login(@RequestBody Consumer consumer) throws NoSuchAlgorithmException{
		Consumer daoC=consumerService.getLogin(consumer.getUsername());
		System.out.println(daoC.getPassword());
		return ResponseEntity.ok(daoC);
	}
	
	// ADD POST
	@PutMapping("/addpost")
	public ResponseEntity<Consumer> addPost(@RequestBody Consumer consumer){
//		System.out.println(consumer.getConsumerId());
		Consumer added=consumerService.addPost(consumer);
		if(added!=null) return ResponseEntity.ok(added);
		return new ResponseEntity<Consumer>(HttpStatus.BAD_REQUEST);
	}
}
