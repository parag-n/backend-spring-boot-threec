package com.threec.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.threec.beans.Address;

public interface AddressDao extends JpaRepository<Address, Integer>{

}
