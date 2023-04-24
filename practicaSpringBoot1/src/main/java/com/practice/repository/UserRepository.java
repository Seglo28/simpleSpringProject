package com.practice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{

	public Optional<UserEntity> findByFirtsName (String firtsName);
}
