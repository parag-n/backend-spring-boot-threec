package com.threec.beans;

import java.util.List;

public class Post {
	private int postId;
	private int consumerId;
	private String title;
	private String description;
	private Expertise category;
	private String status;//bids open 2. close 3.pending work 4. work completed 
	private Address address;
	private List<Bid> bids;
	
	

}
