package com.threec.beans;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Post {
	@Id
	@GeneratedValue
	private int postId;
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Consumer consumer;
	private String title;
	private String description;
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Expertise category;
	private String status;//bids open 2. close 3.pending work 4. work completed 
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Address address;
	@OneToMany(mappedBy = "post", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Bid> bids;
}
