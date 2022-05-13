package com.cg.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.*;

  //POJO Class
@Data
@AllArgsConstructor
@Document(collection = "Orders")
public class BookingOrder {
	
	   //Attributes
	@Id  //Primary Key
	private String id;
	private String itemName;
	private String quantity;
	
	//default constructor
	
	public BookingOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

	   //parameterized constructor
	
	public BookingOrder(String id, String itemName, String quantity) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.quantity = quantity;
	}
	
	// setters and getters

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

    //toString

	@Override
	public String toString() {
		return "BookingOrder [id=" + id + ", itemName=" + itemName + ", quantity=" + quantity + "]";
	}
	
	
	
	
}


