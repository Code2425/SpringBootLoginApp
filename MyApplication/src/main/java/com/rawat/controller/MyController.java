package com.rawat.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rawat.model.User;
import com.rawat.services.UserService;

@Controller
public class MyController {

	@Autowired
	UserService userService;

	@RequestMapping("/welcome")
	public String Welcome(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_HOME");

		return "welcomePage";
	}

	@RequestMapping("/registration")
	public String userRegistration(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_REGISTER");
		return "welcomePage";
	}

	@PostMapping("/save-user")
	public String registUser(@ModelAttribute User user, BindingResult bindingResult, HttpServletRequest request) {
		userService.saveUser(user);
		request.setAttribute("mode", "MODE_HOME");
		return "welcomePage";
	}
	
	
	@GetMapping("/show-users")
	public String showAllUsers(HttpServletRequest request) {
	
		request.setAttribute("users",userService.getAllUsers());
		request.setAttribute("mode", "ALL_USERS");
		return "welcomePage";
	}
	
	@RequestMapping("/delete-user")
	public String deleteUser(@RequestParam int id, HttpServletRequest request) {
		userService.deleteUser(id);
		request.setAttribute("mode", "ALL_USERS");
		return "welcomePage";
	}

}
