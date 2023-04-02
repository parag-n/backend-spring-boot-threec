package com.threec.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BidDetails {

	@Id
	private int bidDetailsId;
	private double amount;
	private String note;
	private String serviceProviderName;
	
}
