package com.practice.service;

import com.practice.entities.UserEntity;

public interface UserService {

	public UserEntity save (UserEntity user);
	
	public Iterable<UserEntity> findAll ();
	
	public UserEntity findById (int id);
	
	public UserEntity update (UserEntity user);
	
}
