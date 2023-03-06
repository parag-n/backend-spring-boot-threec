package com.threec.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.threec.beans.Bid;
import com.threec.service.BidService;

@RestController
@RequestMapping("/bid")
@CrossOrigin("*")
public class BidController {
	@Autowired
	BidService bidService;
	
	// CREATE
	@PostMapping("/bids")
	public ResponseEntity<Bid> createBid(@RequestBody Bid bid){
		Bid created=bidService.createBid(bid);
		if(created!=null) return ResponseEntity.ok(created);
		return new ResponseEntity<Bid>(HttpStatus.BAD_REQUEST);
	}
	
	// READ ONE
	@GetMapping("/bids/{bidId}")
	public ResponseEntity<Bid> readBid(@PathVariable int bidId){
		Bid bid=bidService.readBid(bidId);
		if(bid!=null) return ResponseEntity.ok(bid);
		return new ResponseEntity<Bid>(HttpStatus.NOT_FOUND);
	}
	
	// READ ALL
	@GetMapping("/bids")
	public ResponseEntity<List<Bid>> readAllBids(){
		List<Bid> blist=bidService.readAllBids();
		if(blist!=null) return ResponseEntity.ok(blist);
		return new ResponseEntity<List<Bid>>(HttpStatus.NOT_FOUND);
	}
	
	// UPDATE
	
	// DELETE
	@DeleteMapping("/bids/{bidId}")
	public ResponseEntity<String> deleteBid(@PathVariable int bidId){
		boolean status=bidService.deleteBid(bidId);
		if(status) return ResponseEntity.ok("Deleted successfully!");
		return new ResponseEntity<String>("Bid not present!", HttpStatus.NOT_FOUND);
	}
	
}
