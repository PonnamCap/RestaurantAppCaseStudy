package com.cg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.exception.RestaurantAlreadyExists;
import com.cg.exception.RestaurantIdNotFound;
import com.cg.model.Restaurant;

@Service

public interface RestaurantService {
	
	public Restaurant addRestaurant(Restaurant restaurant)  throws RestaurantAlreadyExists;
	public List<Restaurant> getAllRestaurants()  ;
	Restaurant updateRestaurant(Restaurant restaurant, String restaurantId) throws RestaurantIdNotFound;
	public void deleteRestaurantByrestaurantId(String restaurantId) throws RestaurantIdNotFound;

}