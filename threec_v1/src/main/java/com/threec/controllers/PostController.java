package com.threec.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.threec.beans.Post;
import com.threec.service.PostService;

@RequestMapping("/post")
@RestController
public class PostController {
	
	@Autowired
	PostService postService;
	
	// CREATE
	@PostMapping("/posts")
	public ResponseEntity<Post> createPost(@RequestBody Post post){
		Post created=postService.createPost(post);
		if(created!=null) return ResponseEntity.ok(created);
		else return new ResponseEntity<Post>(HttpStatus.BAD_REQUEST);
	}
}
