package com.threec.controllers;

import java.util.List;

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

import com.threec.beans.Post;
import com.threec.service.PostService;

@RestController
@RequestMapping("/post")
@CrossOrigin("*")
public class PostController {
	@Autowired
	PostService postService;
	
	// CREATE A NEW POST
	@PostMapping("/post")
	public ResponseEntity<Post> create(@RequestBody Post post, @RequestAttribute String username){
		Post created=postService.create(post, username);
		if(created==null) return new ResponseEntity<Post>(HttpStatus.NOT_FOUND);
		return ResponseEntity.ok(created);
	}
	
	// RETRIEVE ALL THE POSTS OF A CONSUMER
	@GetMapping("/posts/consumer")
	public ResponseEntity<List<Post>> readAllForConsumer(@RequestAttribute String username){
		List<Post> plist=postService.readAllForConsumer(username);
		if(plist==null) return new ResponseEntity<List<Post>>(HttpStatus.NOT_FOUND);
		return ResponseEntity.ok(plist);
	}
	
	// RETRIEVE ALL THE OPEN POSTS RELATED TO A SERVICE PROVIDER
	@GetMapping("/posts/serviceprovider")
	public ResponseEntity<List<Post>> readAllForServiceProvider(@RequestAttribute String username){
		List<Post> plist=postService.readAllForServiceProvider(username);
		if(plist==null) return new ResponseEntity<List<Post>>(HttpStatus.NOT_FOUND);
		return ResponseEntity.ok(plist);
	}
}
