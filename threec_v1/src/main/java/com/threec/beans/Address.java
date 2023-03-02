package com.threec.beans;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Address {
	@Id
	@GeneratedValue
	private int addressId;
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Consumer consumer;
	private String details;
	private String locality;
	private int pincode;
	private String city;
}
