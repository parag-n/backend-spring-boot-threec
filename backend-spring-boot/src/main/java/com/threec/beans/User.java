package com.threec.beans;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Parent class of both the consumer and the service provider.
 * It stores the common details in the above mentioned classes.
 * 
 * 
 * @author Parag Nukalwar
 *
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"username","phone", "email" }))
public class User implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2449483571993826327L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String username;
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	@Enumerated(EnumType.STRING)
	private Role role;
	@JsonIgnore
	private String salt;
	
	// BASIC DETAILS
	private String fullname;
	private long phone;
	private String email;

	/**
	 * Constructor for login verification details.
	 * @param userId
	 * @param username
	 * @param password
	 * @param salt
	 * @param role
	 */
	public User(int userId, String username, String password, String salt, Role role) {
		this.userId=userId;
		this.username=username;
		this.password=password;
		this.salt=salt;
		this.role=role;
	}

	
	/**
	 * Overridden methods from UserDetails
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority(role.name()));
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	@Override
	public boolean isEnabled() {
		return true;
	}
}