package com.practice.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "User")
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int idUser;
	@Column(name = "firtsName", length=50, nullable=false, unique=false)
	public String firtsName = "";
	@Column(name = "lastName", length=50, nullable=false, unique=false)
	public String lastName = "";
	@Column(name = "password", length=50, nullable=false, unique=false)
	public String password = "";
	
	public UserEntity() {
		
	}
	
	public UserEntity(int idUser, String firtsName, String lastName, String password) {
		this.idUser = idUser;
		this.firtsName = firtsName;
		this.lastName = lastName;
		this.password = password;
	}

	public int getIdUser() {
		return idUser;
	}


	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}


	public String getFirtsName() {
		return firtsName;
	}


	public void setFirtsName(String firtsName) {
		this.firtsName = firtsName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
}
