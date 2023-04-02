package com.threec.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@PrimaryKeyJoinColumn(name = "userId")
public class Consumer extends User{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 36067569630285017L;
	

	@OneToMany(mappedBy = "consumer", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Address> addresses;

	@OneToMany(mappedBy = "consumer", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Post> posts;

}