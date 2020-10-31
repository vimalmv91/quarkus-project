package com.hackathon.quarkus.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.hackathon.quarkus.entity.User;
import com.hackathon.quarkus.repository.UserRepository;

@ApplicationScoped
public class UserServiceImpl {
	
	@Inject
	private UserRepository userRepository;
	
	
	public List<User> fetchAllUsers() {
		return userRepository.listAll();
	}
	
	
	public boolean login(User userVO) {
        System.out.println("The userVO is **************** : " + userVO.getEmailId());
		User user = userRepository.findByUserEmailId(userVO.getEmailId());
        System.out.println("The user is **************** : " + user.toString());

		return (user!=null && userVO.getPassword().equals(user.getPassword()));
	}

}
