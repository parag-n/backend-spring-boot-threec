package com.threec.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.threec.beans.Consumer;

public interface ConsumerDao extends JpaRepository<Consumer, Integer>{
	

}
