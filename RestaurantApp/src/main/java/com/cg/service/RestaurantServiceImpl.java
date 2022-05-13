package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.exception.RestaurantAlreadyExists;
import com.cg.exception.RestaurantIdNotFound;
import com.cg.model.Restaurant;
import com.cg.repository.RestaurantRepository;
@Service
public  class RestaurantServiceImpl implements RestaurantService{
	
	private RestaurantRepository restaurantRepo;

    @Autowired
	public RestaurantServiceImpl(RestaurantRepository restaurantRepo) {
		super();
		this.restaurantRepo = restaurantRepo;
	}

	@Override
	public Restaurant addRestaurant(Restaurant restaurant) throws RestaurantAlreadyExists {
		// TODO Auto-generated method stub
		if(restaurantRepo.existsById(restaurant.getRestaurantId())) {
			throw new RestaurantAlreadyExists();
		}
		Restaurant savedRestaurant = restaurantRepo.save(restaurant);
		return savedRestaurant;
	}

	@Override
	public List<Restaurant> getAllRestaurants()  {
		// TODO Auto-generated method stub
		
		return (List<Restaurant>) restaurantRepo.findAll();

	}

	@Override
	public Restaurant updateRestaurant(Restaurant restaurant, String restaurantId) throws RestaurantIdNotFound {
		// TODO Auto-generated method stub
		
		
		Optional<Restaurant> restaurantDB =this.restaurantRepo.findById(restaurant.getRestaurantId());
		if(restaurantDB.isPresent()) {
			Restaurant restaurantUpdate = restaurantDB.get();
	    restaurantUpdate.setRestaurantId(restaurant.getRestaurantId());
	    restaurantUpdate.setRestaurantName(restaurant.getRestaurantName());
	    restaurantUpdate.setRestaurantLoc(restaurant.getRestaurantLoc());
	    restaurantUpdate.setRestaurantRating(restaurant.getRestaurantRating());
	    restaurantRepo.save(restaurant);
		return restaurant;
	}
		else
		{
        throw new RestaurantIdNotFound(); 
		}
	}
		

	@Override
	public void deleteRestaurantByrestaurantId(String restaurantId) throws RestaurantIdNotFound{
		// TODO Auto-generated method stub
	Optional<Restaurant> restaurantDB = this.restaurantRepo.findById(restaurantId);
		if(restaurantDB.isPresent()) { 
			this.restaurantRepo.delete(restaurantDB.get());
		}
		else
		{
			throw new RestaurantIdNotFound();
			
		}
		

	}

}
