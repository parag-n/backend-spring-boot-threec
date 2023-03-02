package com.threec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.threec.beans.Address;
import com.threec.dao.AddressDao;

@Service
public class AddressServiceImpl implements AddressService{
	@Autowired
	AddressDao addressDao;

	@Override
	public Address createAddress(Address address) {
		return addressDao.save(address);
	}
	

}
