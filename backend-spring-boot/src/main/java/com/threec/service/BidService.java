package com.threec.service;

import java.util.List;

import com.threec.beans.Bid;
import com.threec.dto.BidDetails;

public interface BidService {

	Bid create(Bid bid, String username);

	List<BidDetails> getBidsOnPost(int postId);

	boolean acceptBid(int bidId);

}
