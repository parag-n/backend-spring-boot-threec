package com.threec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.threec.beans.Bid;
import com.threec.dao.BidDao;

@Service
public class BidServiceImpl implements BidService{
	@Autowired
	BidDao bidDao;

	@Override
	public Bid createBid(Bid bid) {
		return bidDao.save(bid);
	}

	@Override
	public Bid readBid(int bidId) {
		return bidDao.findById(bidId).orElse(null);
	}

	@Override
	public List<Bid> readAllBids() {
		return bidDao.findAll();
	}

	@Override
	public boolean deleteBid(int bidId) {
		Bid bid=readBid(bidId);
		if(bid==null) return false;
		bidDao.delete(bid);
		return true;
	}
}
