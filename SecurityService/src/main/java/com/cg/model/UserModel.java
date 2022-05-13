package com.cg.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//POJO class
@Document(collection="users")
public class UserModel {
	
	@Id  //Primary Key // attributes
	private String id;
    private String username;
	private String password;

	//default constructor
	
	public UserModel() {
		// TODO Auto-generated constructor stub
	}

    // setters and getters

	public String getId() {
		return id;
	}

	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}