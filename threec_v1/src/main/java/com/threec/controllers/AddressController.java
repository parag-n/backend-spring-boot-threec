package com.threec.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.threec.beans.Address;
import com.threec.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {
	@Autowired
	AddressService addressService;
	
	// CREATE
	@PostMapping("/addresses")
	public ResponseEntity<Address> createAddress(@RequestBody Address address){
		Address created=addressService.createAddress(address);
		if(created!=null) return ResponseEntity.ok(created);
		else return new ResponseEntity<Address>(HttpStatus.BAD_REQUEST);
	}
}
