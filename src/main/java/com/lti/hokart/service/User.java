package com.lti.hokart.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.lti.hokart.Repository.UserRepository;

public class User {
	    
	    @Autowired
	    private UserRepository userRepository;
	    
	    public User createUser(User user) {
	        return userRepository.save(user);
	    }
	    
	    public User getUserByEmail(String email) {
	        return userRepository.findByEmail(email);
	    }
	    
	    // other methods for updating and deleting user
	    
	}
