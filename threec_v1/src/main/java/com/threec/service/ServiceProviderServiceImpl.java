package com.threec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.threec.beans.ServiceProvider;
import com.threec.dao.ServiceProviderDao;

@Service
public class ServiceProviderServiceImpl implements ServiceProviderService{

	@Autowired
	ServiceProviderDao serviceProviderDao;

	@Override
	public ServiceProvider createServiceProvider(ServiceProvider sp) {
		return serviceProviderDao.save(sp);
	}

	@Override
	public ServiceProvider readServiceProvider(int serviceProviderId) {
		Optional<ServiceProvider> op=serviceProviderDao.findById(serviceProviderId);
		return op.orElse(null);
	}

	@Override
	public List<ServiceProvider> readAll() {
		return serviceProviderDao.findAll();
	}

	@Override
	public boolean deleteSP(int spid) {
		ServiceProvider sp=readServiceProvider(spid);
		if(sp==null) return false;
		serviceProviderDao.delete(sp);
		return true;
	}
	
}
