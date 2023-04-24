package com.practice.implement;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.practice.entities.UserEntity;
import com.practice.repository.UserRepository;
import com.practice.service.UserService;

@Service
public class UserRepositoryImplement implements UserService{

	@Autowired //Aquí lo inyecte, inyeccción de dependencias.-
	private UserRepository userRepository;

	//@Override
	//@Transactional
	private void saveOne (UserEntity userData) {
		UserEntity userEntity = new UserEntity();
		Optional<UserEntity> dbName = userRepository.findByFirtsName(userData.firtsName);
		if(dbName.isEmpty()) {
			userEntity.setFirtsName(userData.firtsName);
			userEntity.setLastName(userData.lastName);
			userEntity.setPassword(userData.password);
			userRepository.save(userEntity);
		}
	}
	
	@Override
	public UserEntity save(UserEntity user) {
		UserEntity User = new UserEntity ();
		this.saveOne(user);
		Optional<UserEntity> userSaved = userRepository.findByFirtsName(user.firtsName);
		if(userSaved.isPresent()) {
			User = userSaved.get();
		}
		return User;
	}

	@Transactional(readOnly = true) // Solo le indico que leera de la base de datos
	@Override
	public Iterable<UserEntity> findAll() {
		return userRepository.findAll();
	}

	@Override
	public UserEntity findById(int id) {
		return userRepository.getReferenceById(id);
	}

	@Override
	public UserEntity update(UserEntity userData) {
		UserEntity user =  userRepository.findById(userData.getIdUser()).get();                                                                              
		Optional<UserEntity> validateUser = userRepository.findById(userData.getIdUser());
		if(validateUser.isPresent()) {   
			user.setFirtsName(userData.firtsName);
			user.setLastName(userData.lastName);
			user.setPassword(userData.password);
			userRepository.save(user);
		}
		return user;
	}
}
