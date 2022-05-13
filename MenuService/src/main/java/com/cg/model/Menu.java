package com.cg.model;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.*;

//POJO Class

@Data
@AllArgsConstructor
@Document(collection = "Menu")

public class Menu {

   //Attributes
   @Id  // primary key
   private String id;
   private String name;
   private String category;
   private double price;
   
	//default constructor

public Menu() {
	super();
	// TODO Auto-generated constructor stub
}

    //parameterized constructor

	public Menu(String id, String name, String category, double price) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

    //toString

	@Override
	public String toString() {
		return "Menu [id=" + id + ", name=" + name + ", category=" + category + ", price=" + price + "]";
	}
 
}