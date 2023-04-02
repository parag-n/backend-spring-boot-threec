package com.threec.service;

import java.util.List;

import com.threec.beans.Bid;
import com.threec.beans.ServiceProvider;

public interface ServiceProviderService {

	ServiceProvider register(ServiceProvider sp);

	ServiceProvider findByUsername(String username);

	List<Bid> findAllBids(String username);

}
