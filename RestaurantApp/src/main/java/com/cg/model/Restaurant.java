package com.cg.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//POJO Class

@Document(collection = "restaurants")
public class Restaurant {
	
	        //Attributes
		@Id // primary key

		private String restaurantId;
		private String restaurantName;
		private String restaurantLoc;
		private String restaurantRating;
		
		//default constructor

		public Restaurant() {
			super();
			// TODO Auto-generated constructor stub
		}

		   //parameterized constructor


		public Restaurant(String restaurantId, String restaurantName, String restaurantLoc, String restaurantRating) {
			super();
			this.restaurantId = restaurantId;
			this.restaurantName = restaurantName;
			this.restaurantLoc = restaurantLoc;
			this.restaurantRating = restaurantRating;
		}
		
	    // setters and getters


		public String getRestaurantId() {
			return restaurantId;
		}

		public void setRestaurantId(String restaurantId) {
			this.restaurantId = restaurantId;
		}

		public String getRestaurantName() {
			return restaurantName;
		}

		public void setRestaurantName(String restaurantName) {
			this.restaurantName = restaurantName;
		}

		public String getRestaurantLoc() {
			return restaurantLoc;
		}

		public void setRestaurantLoc(String restaurantLoc) {
			this.restaurantLoc = restaurantLoc;
		}

		public String getRestaurantRating() {
			return restaurantRating;
		}

		public void setRestaurantRating(String restaurantRating) {
			this.restaurantRating = restaurantRating;
		}
		
	    //toString

		@Override
		public String toString() {
			return "Restaurant [restaurantId=" + restaurantId + ", restaurantName=" + restaurantName
					+ ", restaurantLoc=" + restaurantLoc + ", restaurantRating=" + restaurantRating + "]";
		}
		
		
		

}
