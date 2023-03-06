package com.threec.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.threec.beans.ServiceProvider;

public interface ServiceProviderDao extends JpaRepository<ServiceProvider, Integer>{

}
