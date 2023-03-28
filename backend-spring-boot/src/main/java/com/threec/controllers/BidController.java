package com.threec.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.threec.beans.Bid;
import com.threec.service.BidService;

@RestController
@CrossOrigin("*")
@RequestMapping("/bid")
public class BidController {

	@Autowired
	BidService bidService;
	
	@PostMapping("/bid")
	public ResponseEntity<Bid> create(@RequestBody Bid bid, @RequestAttribute String username){
		Bid created=bidService.create(bid, username);
		if(created==null) return new ResponseEntity<Bid>(HttpStatus.BAD_REQUEST);
		return ResponseEntity.ok(created);
	}
}
