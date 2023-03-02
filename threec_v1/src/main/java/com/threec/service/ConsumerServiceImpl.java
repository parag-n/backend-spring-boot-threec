package com.threec.service;

import java.util.List;
import java.util.Optional;

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

	@Override
	public Consumer readConsumer(int consumerId) {
		Optional<Consumer> consumer=consumerDao.findById(consumerId);
		return consumer.orElse(null);
	}

	@Override
	public List<Consumer> readAllConsumers() {
		return consumerDao.findAll();
	}

	@Override
	public Consumer updateConsumer(Consumer consumer) {
		if(consumer.getConsumerId()!=0 && consumer.getName()!=null && consumer.getPassword()!=null) {
			Optional<Consumer> old=consumerDao.findById(consumer.getConsumerId());
			if(old.isPresent()) {
				Consumer newConsumer=old.get();
				newConsumer.setName(consumer.getName());
				newConsumer.setPassword(consumer.getPassword());
				consumerDao.save(newConsumer);
				return newConsumer;
			}
		}
		return null;
	}

	@Override
	public boolean deleteConsumer(int consumerId) {
		Optional<Consumer> consumer=consumerDao.findById(consumerId);
		if(consumer.isPresent()) {
			consumerDao.deleteById(consumerId);
			return true;
		}
		return false;
	}

	@Override
	public Consumer addPost(Consumer consumer) {
		int id=consumer.getConsumerId();
		Optional<Consumer> findCon=consumerDao.findById(id);
		if(findCon.isPresent()) {
			
		}
	}
}
