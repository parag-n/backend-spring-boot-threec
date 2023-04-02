package com.threec.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.threec.beans.Address;
import com.threec.service.AddressService;

@RestController
@RequestMapping("/address")
@CrossOrigin("*")
public class AddressController {

	@Autowired
	AddressService addressService;

	// ADD NEW ADDRESS
	@PostMapping("/address")
	public ResponseEntity<Address> create(@RequestBody Address address, @RequestAttribute String username){
		Address created=addressService.create(address,username);
		if(created==null) return new ResponseEntity<Address>(HttpStatus.BAD_REQUEST);
		return ResponseEntity.ok(created);
	}
	
	// ADD MULTIPLE ADDRESSES
	@PostMapping("/addresses")
	public ResponseEntity<List<Address>> createMany(@RequestBody List<Address> alist, @RequestAttribute String username){
		List<Address> created=addressService.createMany(alist, username);
		if(created==null) return new ResponseEntity<List<Address>>(HttpStatus.BAD_REQUEST);
		return ResponseEntity.ok(created);
	}
	
	// RETRIEVE ALL ADDRESSES OF A CONSUMER
	@GetMapping("/addresses")
	public ResponseEntity<List<Address>> readAll(@RequestAttribute String username){
		List<Address> alist=addressService.readAll(username);
		if(alist==null) return new ResponseEntity<List<Address>>(HttpStatus.NOT_FOUND);
		return ResponseEntity.ok(alist);
	}
	
	// RETRIEVE AN ADDRESS OF A CONSUMER BY ADDRESSID
	@GetMapping("/addresses/{addressId}")
	public ResponseEntity<Address> readOne(@PathVariable int addressId){
		Address found=addressService.findById(addressId);
		if(found==null) return new ResponseEntity<Address>(HttpStatus.NOT_FOUND);
		return ResponseEntity.ok(found);
	}
}
