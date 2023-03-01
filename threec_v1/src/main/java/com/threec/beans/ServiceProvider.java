package com.threec.beans;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class ServiceProvider {
	@Id
	@GeneratedValue
	private int serviceProviderId;
	private String name;
	private String phone;
	private String email;
	@OneToMany(mappedBy = "serviceProvider", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Bid> bids;
	private String password;
	private String city;
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name="sp_exp_map", joinColumns = {@JoinColumn(name="serviceProviderId")}, 
	inverseJoinColumns = {@JoinColumn(name="expertiseId")})
	private List<Expertise> expertise;
	
}