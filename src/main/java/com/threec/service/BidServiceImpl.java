package com.threec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.threec.beans.Bid;
import com.threec.beans.Post;
import com.threec.beans.ServiceProvider;
import com.threec.dao.BidDao;
import com.threec.dao.PostDao;
import com.threec.dto.BidDetails;
import com.threec.enums.PostStatus;
@Service
public class BidServiceImpl implements BidService{
	@Autowired
	BidDao bidDao;
	
	@Autowired
	PostDao postDao;

	@Autowired
	ServiceProviderService serviceProviderService;
	
	@Override
	public Bid create(Bid bid, String username) {
		ServiceProvider found=serviceProviderService.findByUsername(username);
		if(found==null) return null;
		bid.setServiceProvider(found);
		return bidDao.save(bid);
	}

	@Override
	public List<BidDetails> getBidsOnPost(int postId) {
		List<BidDetails> blist=bidDao.findAllByPostId(postId);
		return blist;
	}

	// ACCEPT THE BID
	@Override
	public boolean acceptBid(int bidId) {
		Bid bid=bidDao.findById(bidId).orElse(null);
		if(bid==null) return false;
		Post post=bid.getPost();
		if(!post.getStatus().equals(PostStatus.BIDS_OPEN)) return false;
		post.setStatus(PostStatus.BID_ACCEPTED);
		Post savedP=postDao.save(post);
		bid.setAccepted(true);
		Bid savedB=bidDao.save(bid);
		if(savedB!=null && savedP!=null)return true;
		return false;
	}

}
