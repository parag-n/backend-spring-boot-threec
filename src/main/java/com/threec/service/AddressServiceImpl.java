package com.threec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.threec.beans.Address;
import com.threec.beans.Consumer;
import com.threec.dao.AddressDao;

@Service
public class AddressServiceImpl implements AddressService{
	
	@Autowired
	ConsumerService consumerService;
	
	@Autowired
	AddressDao addressDao;

	// ADD NEW ADDRESS
	@Override
	public Address create(Address address, String username) {
		
		Consumer found=consumerService.findByUsername(username);
		if(found==null) return null;
		
		address.setConsumer(found);
		return addressDao.save(address);
		
	}

	// ADD MULTIPLE ADDRESSES
	@Override
	public List<Address> createMany(List<Address> alist, String username) {
		Consumer found=consumerService.findByUsername(username);
		if(found==null) return null;
		
		for(Address a:alist) {
			a.setConsumer(found);
		}
		
		return addressDao.saveAll(alist);
	}

	// RETRIEVE ALL THE ADDRESSES OF A CONSUMER
	@Override
	public List<Address> readAll(String username) {
		Consumer found=consumerService.findByUsername(username);
		if(found==null)	return null;
		return found.getAddresses();
	}

	// RETRIEVE AN ADDRESS OF A CONSUMER BY ADDRESSID
	public Address findById(int addressId) {
		return addressDao.findById(addressId).orElse(null);
	}
}
