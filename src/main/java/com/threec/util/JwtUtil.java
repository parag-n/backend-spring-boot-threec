package com.threec.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

/**
 * A utility class to facilitate all the operations related to a JWT
 * @author Parag Nukalwar
 *
 */
@Service
public class JwtUtil {

	/**
	 * The secret string to create a signing key
	 */
	private static final String MY_SECRET_KEY="5A7134743777217A24432646294A404E635266556A586E3272357538782F413F";
	
	/**
	 * A method to extract the username from the JWT token
	 * @param jwt
	 * @return
	 */
	public String extractUsername(String jwt) {
		return extractClaim(jwt, Claims::getSubject);
	}
	
	/**
	 * Method to extract the expiration date of the JWT
	 * <p>
	 * Returns the Date object of the expiration date of the JWT
	 * @param jwt
	 * @return
	 */
	private Date extractExpiration(String jwt) {
		return extractClaim(jwt, Claims::getExpiration);
	}

	/**
	 * Generic method to extract a given type of claim
	 * @param <T>
	 * @param jwt
	 * @param claimsResolver
	 * @return
	 */
	public <T> T extractClaim(String jwt, Function<Claims, T> claimsResolver) {
		final Claims claims=extractAllClaims(jwt);
//		System.out.println(claims);
		return claimsResolver.apply(claims);
	}
	
	/**
	 * A method to extract all the claims from a given JWT token string
	 * @param jwt
	 * @return
	 */
	private Claims extractAllClaims(String jwt) {
		return Jwts
				.parserBuilder()
				.setSigningKey(getMyKey())
				.build()
				.parseClaimsJws(jwt)
				.getBody();
	}

	/**
	 * A private method to generate a Key from a given secret string
	 * @return
	 */
	private SecretKey getMyKey() {
		byte[] key=Decoders.BASE64.decode(MY_SECRET_KEY);
		return Keys.hmacShaKeyFor(key);
	}
	
	/**
	 * Method to check if the JWT is valid.
	 * <p>
	 * For validation, it checks the username and the expiration date
	 * @param jwt
	 * @param userDetails
	 * @return
	 */
	public boolean isTokenValid(String jwt, UserDetails userDetails) {
		final String username=extractUsername(jwt);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(jwt));
	}

	/**
	 * Method to check if the token is expired.
	 * <p>
	 * Returns true if the expiration date of the JWT has passed.
	 * @param jwt
	 * @return
	 */
	private boolean isTokenExpired(String jwt) {
		return extractExpiration(jwt).before(new Date());
	}

	/**
	 * Method to generate a JWT without registering any extra claims
	 * @param userDetails
	 * @return
	 */
	public String generateToken(UserDetails userDetails) {
//		System.out.println("generate token called");
		return generateToken(new HashMap<>(), userDetails);
	}
	
	/**
	 * Method to generate a JWT along with passing some extra claims
	 * @param extraClaims
	 * @param userDetails
	 * @return
	 */
	public String generateToken(Map<String, Object> extraClaims,
			UserDetails userDetails) {
		return Jwts
				.builder()
				.setClaims(extraClaims)
				.setSubject(userDetails.getUsername())
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000*60*60*24))
				.signWith(getMyKey(), SignatureAlgorithm.HS256)
				.compact();
	}
}
