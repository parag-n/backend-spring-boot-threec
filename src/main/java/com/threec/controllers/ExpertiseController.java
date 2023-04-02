package com.threec.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.threec.beans.Expertise;
import com.threec.service.ExpertiseService;

@RestController
@RequestMapping("/expertise")
@CrossOrigin("*")
public class ExpertiseController {
	@Autowired
	ExpertiseService expertiseService;
	
	// ADD A NEW EXPERTISE
	@PostMapping("/expertise")
	public ResponseEntity<Expertise> create(@RequestBody Expertise expertise){
		Expertise created=expertiseService.create(expertise);
		if(created==null) return new ResponseEntity<Expertise>(HttpStatus.BAD_REQUEST);
		return ResponseEntity.ok(created);
	}
	
	// ADD MULTIPLE NEW EXPERTISES
	@PostMapping("/expertises")
	public ResponseEntity<List<Expertise>> createMany(@RequestBody List<Expertise> expertises){
		List<Expertise> created=expertiseService.createMany(expertises);
		if(created==null) return new ResponseEntity<List<Expertise>>(HttpStatus.BAD_REQUEST);
		return ResponseEntity.ok(created);
	}
	
	// RETRIEVE ALL EXPERTISES
	@GetMapping("/expertises")
	public ResponseEntity<List<Expertise>> readAll(){
		List<Expertise> all=expertiseService.readAll();
		if(all==null) return new ResponseEntity<List<Expertise>>(HttpStatus.NOT_FOUND);
		return ResponseEntity.ok(all);
	}
}
