package com.threec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.threec.dao.UserRepository;

/**
 * Service class for the User
 * @author Parag Nukalwar
 *
 */
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	/**
	 * Implementation of the method inherited from the UserDetailsService interface.
	 * <p>
	 * Takes the {@code username} as an input, returns the UserDetails object.
	 * The UserDetails interface is already implemented by our User class.
	 * @return UserDetails
	 * @throws UsernameNotFoundException
	 * @
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("==========>load user by username called!<==========");
//		UserDetails u=userRepository.findByUsername(username).orElse(null);
//		System.out.println(u);
		return userRepository.findByUsername(username)
				.orElseThrow(()->new UsernameNotFoundException("TC User was not found ==>"));
	}

}
