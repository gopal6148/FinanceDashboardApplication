package com.example.FinanceDashboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.FinanceDashboard.entity.User;
import com.example.FinanceDashboard.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	 public User createUser(User user) {
	        return userRepo.save(user);
	    }

	    public List<User> getAllUsers() {
	        return userRepo.findAll();
	    }

	    public void deactivateUser(Long id) {
	        User user = userRepo.findById(id)
	                .orElseThrow(() -> new RuntimeException("User not found"));
	        user.setActive(false);
	        userRepo.save(user);
	    }

}
