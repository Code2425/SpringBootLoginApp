package com.rawat.repository;

import org.springframework.data.repository.CrudRepository;

import com.rawat.model.User;

public interface UserRepo 
extends CrudRepository<User, Integer> {

	User findByUserNameAndPassword(String userName, String password);
	
}
