package com.example.FinanceDashboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.FinanceDashboard.entity.Role;
import com.example.FinanceDashboard.entity.User;
import com.example.FinanceDashboard.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@PostMapping
    public User create(@RequestBody User user) {
        return service.createUser(user);
    }

    @GetMapping
    public List<User> getAll() {
        return service.getAllUsers();
    }


    @PutMapping("/{id}/deactivate")
    public String deactivate(@PathVariable Long id) {
        service.deactivateUser(id);
        return "User deactivated";
    }

}
