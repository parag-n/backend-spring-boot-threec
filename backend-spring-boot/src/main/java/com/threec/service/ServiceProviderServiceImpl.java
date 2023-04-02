package com.threec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.threec.beans.Bid;
import com.threec.beans.ServiceProvider;
import com.threec.dao.ServiceProviderDao;
import com.threec.enums.Role;
import com.threec.util.TCUtil;

@Service
public class ServiceProviderServiceImpl implements ServiceProviderService{

	@Autowired
	ServiceProviderDao serviceProviderDao;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public ServiceProvider register(ServiceProvider sp) {
		sp.setRole(Role.SERVICE_PROVIDER);

		// generate and set salt
		String salt= TCUtil.mySaltGenerator();
		sp.setSalt(salt);
		
		// encrypt the password
		sp.setPassword(passwordEncoder.encode(sp.getPassword()));

		return serviceProviderDao.save(sp);
	}

	@Override
	public ServiceProvider findByUsername(String username) {
		return serviceProviderDao.findByUsername(username);
	}

	@Override
	public List<Bid> findAllBids(String username) {
		ServiceProvider found=serviceProviderDao.findByUsername(username);
		if(found==null) return null;
		return found.getBids();
	}

}
