package com.rawat.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rawat.model.User;
import com.rawat.repository.UserRepo;

@Service
@Transactional	
public class UserService {

	@Autowired
	private final UserRepo userRepo;
	
	public UserService(UserRepo userRepo)
	{
		this.userRepo = userRepo;
	}
	
	public void saveUser(User user)
	{
		userRepo.save(user);
	}
	
}
