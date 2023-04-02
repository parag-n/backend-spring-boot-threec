package com.threec.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.threec.beans.AuthRequest;
import com.threec.util.JwtUtil;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {
	
	@Autowired
	AuthenticationManager authManager;
	
	@Autowired
	JwtUtil jwUtil;
	
	@PostMapping("/authenticate")
	public ResponseEntity<String> authenticate(@RequestBody AuthRequest authRequest) throws Exception{
		Authentication auth;
		try {
			auth=authManager.authenticate(
					new UsernamePasswordAuthenticationToken(
							authRequest.getUsername(), 
							authRequest.getPassword()
					)
			);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<String>("Bad Credentials!", HttpStatus.FORBIDDEN);
		}
		String token= jwUtil.generateToken((UserDetails)auth.getPrincipal());
		return ResponseEntity.ok(token);
	}

}
