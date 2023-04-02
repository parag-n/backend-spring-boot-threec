package com.threec.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.threec.beans.Bid;
import com.threec.dto.BidDetails;
import com.threec.service.BidService;

@RestController
@RequestMapping("/bid")
@CrossOrigin("*")
public class BidController {

	@Autowired
	BidService bidService;

	// CREATE A NEW BID
	@PostMapping("/bid")
	public ResponseEntity<Bid> create(@RequestBody Bid bid, @RequestAttribute String username){
		Bid created=bidService.create(bid, username);
		if(created==null) return new ResponseEntity<Bid>(HttpStatus.BAD_REQUEST);
		return ResponseEntity.ok(created);
	}

	// FIND ALL BIDS ON A POST BY POSTID
	@GetMapping("/bids/{postId}")
	public ResponseEntity<List<BidDetails>> bidsOnPost(@PathVariable int postId){
		List<BidDetails> blist=bidService.getBidsOnPost(postId);
		if(blist==null) return new ResponseEntity<List<BidDetails>>(HttpStatus.NOT_FOUND);
		return ResponseEntity.ok(blist);
	}
	
	// ACCEPT A BID BY BIDID
	@PutMapping("/accept/{bidId}")
	public ResponseEntity<String> acceptBid(@PathVariable int bidId){
		boolean status=bidService.acceptBid(bidId);
		if(status) return ResponseEntity.ok("Accepted successfully!");
		return new ResponseEntity<String>("Failed to accept the bid!", HttpStatus.BAD_REQUEST);
	}
}
