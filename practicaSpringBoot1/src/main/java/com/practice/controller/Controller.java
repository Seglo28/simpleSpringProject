package com.practice.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.entities.UserEntity;
import com.practice.implement.UserRepositoryImplement;

@RestController
@RequestMapping("/controller")
public class Controller {
	
	@Autowired
	private UserRepositoryImplement userRepositoryImplement;

	@GetMapping("/save")
	public UserEntity save (@RequestBody UserEntity userData) {
		System.out.print("ESTOY EN EL CONTROLADOR");
		return userRepositoryImplement.save(userData);
	}
	
	@GetMapping("/findAll")
	public Iterable<UserEntity>findAll(){
		return userRepositoryImplement.findAll();
	}
	
	@PostMapping("/update")
	public UserEntity update (@RequestBody UserEntity userEntity) {
		return userRepositoryImplement.update(userEntity);
	}
}
