package com.lti.hokart.service;

import com.lti.hokart.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class User {
	    
	    @Autowired
	    private UserRepository userRepository;
	    
	    public User createUser(User user) {
	        return userRepository.save(user);
	    }
	    
	    // other methods for updating and deleting user
	    
	}
