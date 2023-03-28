package com.threec.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.threec.beans.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	
	Optional<User> findByUsername(String username);
}
