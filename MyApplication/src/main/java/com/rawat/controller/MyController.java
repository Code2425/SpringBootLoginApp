package com.rawat.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

}
