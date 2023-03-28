package com.threec.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.threec.beans.User;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class CustomAuthProvider implements AuthenticationProvider{
	
	private PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
	
	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		System.out.println("in my custom auth ==================**************");
		String username=(String) authentication.getPrincipal();
		String password=authentication.getCredentials().toString();
		User user;
		try {
			user=(User)userDetailsService.loadUserByUsername(username);
			password=password.concat(user.getSalt());
//			System.out.println(password);
//			password=passwordEncoder.encode(password);
			System.out.println(password);
			System.out.println(user.getPassword());
			if(this.passwordEncoder.matches(password, user.getEmail())) {
				return new UsernamePasswordAuthenticationToken(username, null, user.getAuthorities());
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		throw new AuthenticationCredentialsNotFoundException("Wrong username or password given********");
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}

}
