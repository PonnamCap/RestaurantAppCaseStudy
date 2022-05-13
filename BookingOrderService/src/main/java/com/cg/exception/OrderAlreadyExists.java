package com.cg.exception;


public class OrderAlreadyExists extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
     //default constructor
	public OrderAlreadyExists() {
		super();
		// TODO Auto-generated constructor stub
	}
    //Parameterized constructor
	public OrderAlreadyExists(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	

}
