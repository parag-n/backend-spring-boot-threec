package com.threec.service;

import java.util.List;

import com.threec.beans.Bid;

public interface BidService {

	Bid createBid(Bid bid);

	Bid readBid(int bidId);

	List<Bid> readAllBids();

	boolean deleteBid(int bidId);

}
