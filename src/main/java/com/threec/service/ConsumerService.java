package com.threec.service;

import java.util.List;

import com.threec.beans.Consumer;

public interface ConsumerService {

	Consumer register(Consumer consumer);

	Consumer findByConsumerId(int consumerId);

	Consumer findByUsername(String username);
	
	List<Consumer> getAll();

}
