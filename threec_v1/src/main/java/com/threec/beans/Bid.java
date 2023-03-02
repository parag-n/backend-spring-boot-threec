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
public class Bid {
	@Id
	@GeneratedValue
	private int bidId;
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Post post;
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private ServiceProvider serviceProvider;
	private double amount;
	private String note;
}
