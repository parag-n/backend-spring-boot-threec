package com.threec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ThreecApplication {
	public static void main(String[] args) {
//		ConfigurableApplicationContext configurableApplicationContext=
		SpringApplication.run(ThreecApplication.class, args);
		
//		UserDao consumerDao=configurableApplicationContext.getBean(ConsumerDao.class);
		
//		UserDao serviceProviderDao=configurableApplicationContext.getBean(ServiceProviderDao.class);
	}
}