package com.cg.model;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.*;

//POJO Class

@Data
@AllArgsConstructor
@Document(collection = "Contacts")

public class Contact {

   //Attributes
   @Id  // primary key
   private String id;
   
   private String name;
   
   private String phoneNumber;
   
	//default constructor

   public Contact() {
	  super();
	   // TODO Auto-generated constructor stub
  }

   //parameterized constructor

public Contact(String id, String name, String phoneNumber) {
	super();
	this.id = id;
	this.name = name;
	this.phoneNumber = phoneNumber;
}

// setters and getters


public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getPhoneNumber() {
	return phoneNumber;
}

public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}

     //toString

@Override
public String toString() {
	return "Contact [id=" + id + ", name=" + name + ", phoneNumber=" + phoneNumber + "]";
}
   
     
   
       
   }
