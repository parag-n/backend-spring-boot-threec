package com.threec.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.threec.filter.JWTFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

	private final JWTFilter jwtFilter;
	private final AuthenticationProvider authenticationProvider;

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http
			.csrf(csrf-> 
				csrf
					.disable()
			)
			
			.authorizeHttpRequests(authorizeHttpRequests -> 
				authorizeHttpRequests
					.requestMatchers("/auth/**", "/expertise/**").permitAll()
					.requestMatchers(HttpMethod.POST, "/consumer/consumer", "/serviceprovider/serviceprovider").permitAll()
//					.requestMatchers("/consumer/*").hasAnyAuthority("ROLE_CONSUMER")
//					.requestMatchers("/serviceprovider").hasAnyAuthority("SERVICE_PROVIDER")
					.anyRequest().authenticated()
			)
			
			.sessionManagement(sessionManagement->
				sessionManagement
					.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			)
			
			.authenticationProvider(authenticationProvider)
			
			.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}
}