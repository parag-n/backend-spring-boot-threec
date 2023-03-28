package com.threec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.threec.beans.Bid;
import com.threec.beans.ServiceProvider;
import com.threec.dao.BidDao;
@Service
public class BidServiceImpl implements BidService{
	@Autowired
	BidDao bidDao;

	@Autowired
	ServiceProviderService serviceProviderService;
	
	@Override
	public Bid create(Bid bid, String username) {
		ServiceProvider found=serviceProviderService.findByUsername(username);
		if(found==null) return null;
		bid.setServiceProvider(found);
		return bidDao.save(bid);
	}

}
