package com.threec.service;

import java.util.List;

import com.threec.beans.Expertise;

public interface ExpertiseService {

	Expertise create(Expertise expertise);

	List<Expertise> createMany(List<Expertise> expertises);

	List<Expertise> readAll();

}
