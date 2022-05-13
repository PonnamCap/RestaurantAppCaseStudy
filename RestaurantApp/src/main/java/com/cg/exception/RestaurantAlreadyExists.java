package com.cg.exception;

public class RestaurantAlreadyExists extends Exception{
	
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
	     //default constructor
		public RestaurantAlreadyExists() {
			super();
			// TODO Auto-generated constructor stub
		}
	    //Parameterized constructor
		public RestaurantAlreadyExists(String message) {
			super(message);
			// TODO Auto-generated constructor stub
		}
		
		

}