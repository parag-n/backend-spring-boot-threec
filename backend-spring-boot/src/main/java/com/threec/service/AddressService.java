package com.threec.service;

import java.util.List;

import com.threec.beans.Address;

public interface AddressService {

	Address create(Address address, String username);

	List<Address> readAll(String username);

	Address findById(int addressId);

	List<Address> createMany(List<Address> alist, String username);

}
