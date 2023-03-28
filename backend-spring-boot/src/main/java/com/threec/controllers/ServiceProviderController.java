package com.threec.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.threec.beans.ServiceProvider;
import com.threec.service.ServiceProviderService;

@RestController
@CrossOrigin("*")
@RequestMapping("/serviceprovider")
public class ServiceProviderController {
	
	@Autowired
	ServiceProviderService serviceProviderService;
	
	// REGISTER A NEW SERVICE PROVIDER
	@PostMapping("/serviceprovider")
	public ResponseEntity<ServiceProvider> register(@RequestBody ServiceProvider sp){
		
		ServiceProvider registered=serviceProviderService.register(sp);
		if(registered==null) return new ResponseEntity<ServiceProvider>(HttpStatus.BAD_REQUEST);
		return ResponseEntity.ok(registered);
	}
	
	// RETRIEVE SERVICE PROVIDER DETAILS
	@GetMapping("/serviceprovider")
	public ResponseEntity<ServiceProvider> readOne(@RequestAttribute String username){
		ServiceProvider found=serviceProviderService.findByUsername(username);
		if(found==null) return new ResponseEntity<ServiceProvider>(HttpStatus.NOT_FOUND);
		return ResponseEntity.ok(found);
	}

}
