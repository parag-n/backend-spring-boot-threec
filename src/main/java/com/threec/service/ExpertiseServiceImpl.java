package com.threec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.threec.beans.Expertise;
import com.threec.dao.ExpertiseDao;

@Service
public class ExpertiseServiceImpl implements ExpertiseService{

	@Autowired
	ExpertiseDao expertiseDao;

	// CREATE A NEW EXPERTISE
	@Override
	public Expertise create(Expertise expertise) {
		return expertiseDao.save(expertise);
	}

	// CREATE MULTIPLE NEW EXPERTISES
	@Override
	public List<Expertise> createMany(List<Expertise> expertises) {
		return expertiseDao.saveAll(expertises);
	}

	// READ ALL THE EXPERTISES
	@Override
	public List<Expertise> readAll() {
		return expertiseDao.findAll();
	}
	
	
}
