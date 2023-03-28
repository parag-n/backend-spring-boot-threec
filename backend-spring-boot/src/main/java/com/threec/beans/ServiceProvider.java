package com.threec.beans;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@PrimaryKeyJoinColumn(name = "userId")
//@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"email", "phone"}))
public class ServiceProvider extends User{ 
/**
	 * 
	 */
	private static final long serialVersionUID = -6369613708911994912L;
	
	@Column(nullable = false)
	private String city;
	
	// EXTRA DETAILS
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="sp_exp_map", joinColumns = {@JoinColumn(name="userId")}, 
	inverseJoinColumns = {@JoinColumn(name="expertiseId")})
	@Column(nullable = false)
	private List<Expertise> expertise;
	@OneToMany(mappedBy = "serviceProvider", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Bid> bids;

	
}