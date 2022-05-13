package com.cg.controller;

import java.util.List;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.exception.RestaurantAlreadyExists;
import com.cg.exception.RestaurantIdNotFound;
import com.cg.model.Restaurant;
import com.cg.service.RestaurantService;

	

@RestController
@RequestMapping("/api/v1")

public class RestaurantController {
	
	
	@Autowired
	private RestaurantService restaurantServ;

		
		
	
	@PostMapping("/restaurant")
	public ResponseEntity<Restaurant>addRestaurant(@RequestBody Restaurant restaurant) throws RestaurantAlreadyExists {
		Restaurant savedrestaurant = restaurantServ.addRestaurant(restaurant);
		return new ResponseEntity<>(savedrestaurant, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/restaurants")
	public ResponseEntity<List<Restaurant>> getAllRestaurants() {
		return new ResponseEntity<List<Restaurant>>((List<Restaurant>)restaurantServ.getAllRestaurants(),HttpStatus.OK);
		
	}
	
	@PutMapping("/restaurant/{restaurantId}")
	public Restaurant 
	updateRestaurant(@RequestBody Restaurant restaurant, @PathVariable("restaurantId") String restaurantId) throws RestaurantIdNotFound {
		return restaurantServ.updateRestaurant(restaurant,restaurantId);
	}
	
	@DeleteMapping("/restaurant/{restaurantId}")
	public ResponseEntity<Void> deleteEmployeeById(@PathVariable String restaurantId) throws RestaurantIdNotFound   {
		restaurantServ.deleteRestaurantByrestaurantId(restaurantId);
		return ResponseEntity.noContent().build();
	}
	 
	

}
