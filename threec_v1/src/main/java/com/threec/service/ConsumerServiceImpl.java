package com.threec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.threec.beans.Consumer;
import com.threec.dao.ConsumerDao;

@Service
public class ConsumerServiceImpl implements ConsumerService{
	@Autowired
	ConsumerDao consumerDao;
	
	public Consumer createConsumer(Consumer consumer) {
		return consumerDao.save(consumer);
	}
}
