package com.threec.service;

import com.threec.beans.ServiceProvider;

public interface ServiceProviderService {

	ServiceProvider register(ServiceProvider sp);

	ServiceProvider findByUsername(String username);

}
