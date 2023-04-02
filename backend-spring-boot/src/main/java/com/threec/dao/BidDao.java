package com.threec.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.threec.beans.Bid;
import com.threec.dto.BidDetails;

public interface BidDao extends JpaRepository<Bid, Integer>{
	
	@Query("select new BidDetails(bid.bidId, bid.amount, bid.note, bid.serviceProvider.fullname) from Bid bid where bid.post.postId=:pid")
	List<BidDetails> findAllByPostId(@Param("pid") int postId);

}
