package com.rawat.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

	public List<User> getAllUsers() {
		
		List<User> users = new ArrayList<>();
		
		for (User user : userRepo.findAll()) {
			users.add(user);
		}
		
		return users;
		
	}
	
	public void deleteUser(int id)
	{
		userRepo.deleteById(id);
	}
	
	public Optional<User> editUser(int id) {
		return userRepo.findById(id);
	}
	
	public User findByUserNameAndPassword(String userName, String password) {
		return userRepo.findByUserNameAndPassword(userName, password);
	}
	
	
	
	
	
	
}
