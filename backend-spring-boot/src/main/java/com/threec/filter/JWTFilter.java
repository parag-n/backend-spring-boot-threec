package com.threec.filter;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.threec.util.JwtUtil;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JWTFilter extends OncePerRequestFilter{
	
	@Autowired
	private final JwtUtil jwtUtil;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	protected void doFilterInternal(
			HttpServletRequest request, 
			HttpServletResponse response, 
			FilterChain filterChain)
			throws ServletException, IOException 
	{
		final String authHeader=request.getHeader(HttpHeaders.AUTHORIZATION);
		final String jwt;
		final String method=request.getMethod();
		final String username;
		
		// RESPOND TO THE PRE-FLIGHT REQUEST FROM BROWSER (OPTIONS METHOD)
		if(method.equals(HttpMethod.OPTIONS.toString())) {
			response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "http://localhost:3000");
			response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS, "*");
			response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, "*");
		}
		
		/**
		 * if no Authorization header is found,
		 * <p>or</p>
		 * The header doesn't start with the "Bearer " string,
		 * stop the process and returns
		 */
		if(authHeader==null || !authHeader.startsWith("Bearer ")){
			filterChain.doFilter(request, response);
			return;
		}
		
		jwt=authHeader.substring(7);
		username = jwtUtil.extractUsername(jwt);
		/**
		 * Checking if the user exists
		 * <p>AND</p>
		 * User is not authenticated yet
		 */
		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
			
			UserDetails userDetails=userDetailsService.loadUserByUsername(username);
			
			if(jwtUtil.isTokenValid(jwt, userDetails)) {
				UsernamePasswordAuthenticationToken token=new UsernamePasswordAuthenticationToken(
						userDetails,
						null,
						userDetails.getAuthorities()
				);
				token.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				
				request.setAttribute("username", userDetails.getUsername());
				
				// following line should be avoided as it may cause race condition
				SecurityContextHolder.getContext().setAuthentication(token);
			}
		}
		filterChain.doFilter(request, response);
	}
}