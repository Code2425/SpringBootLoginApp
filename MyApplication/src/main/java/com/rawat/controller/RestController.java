package com.rawat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rawat.model.User;
import com.rawat.services.UserService;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String hello() {

		return "This is Home Page";
	}

	@GetMapping("/saveuser")
	public String saveUser(@RequestParam String username, @RequestParam String firstName, @RequestParam String lastName,
			@RequestParam int age, @RequestParam String email, @RequestParam String password) {

		User user = new User(username, firstName, lastName, age, email, password);
		
		userService.saveUser(user);
		return "user saved";
	}
}
