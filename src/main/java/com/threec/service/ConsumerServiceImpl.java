package com.threec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.threec.beans.Consumer;
import com.threec.dao.ConsumerDao;
import com.threec.enums.Role;
import com.threec.util.TCUtil;

@Service
public class ConsumerServiceImpl implements ConsumerService{

	@Autowired
	ConsumerDao consumerDao;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	// REGISTER A NEW CONSUMER
	@Override
	public Consumer register(Consumer consumer) {
		// assign role
		consumer.setRole(Role.CONSUMER);

		// generate and set salt
		String salt= TCUtil.mySaltGenerator();
		consumer.setSalt(salt);

		// encode along with salt
//		String pass=consumer.getPassword().concat(salt);
//		consumer.setPassword(passwordEncoder.encode(pass));

		// encode normal password
		consumer.setPassword(passwordEncoder.encode(consumer.getPassword()));
		return consumerDao.save(consumer);
	}

	// RETRIEVE A CONSUMER BY CONSUMERID
	public Consumer findByConsumerId(int consumerId) {
		return consumerDao.findById(consumerId).orElse(null);
	}

	// RETRIEVE A CONSUMER BY USERNAME
	@Override
	public Consumer findByUsername(String username) {
		return consumerDao.findByUsername(username);
	}
	
	// RETRIEVE ALL CONSUMERS
	@Override
	public List<Consumer> getAll() {
		return consumerDao.findAll();
	}



}
