package com.cg.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.model.Restaurant;


@SpringBootTest
@ExtendWith(SpringExtension.class)
public class RestaurantRepositoryTest {

    @Autowired
	private RestaurantRepository restaurantRepo;
	
	
	@Test
	public void givenRestaurantShouldReturnRestaurantObject() {
		Restaurant r1 = new Restaurant("12I","Sensations","Kukatpally","Awesome"); //user Input
		restaurantRepo.save(r1); //Data is saved into Database
		Restaurant r2 = restaurantRepo.findById(r1.getRestaurantId()).get(); // Fetching the data from database
	assertNotNull(r2); // To check if it is returning the Game Object
	assertEquals(r1.getRestaurantName(), r2.getRestaurantName());
	
	
	
	}
		
	@Test
	public void getAllmustReturnAllRestaurants() {
		
		Restaurant r3 = new Restaurant("2","BBQ","Secunderabad","Good"); //user Input
		Restaurant r4 = new Restaurant("12K","Druken Monkey","L.B.Nagar","Awesome"); // user Input
		restaurantRepo.save(r3); //saving the info to Database
		restaurantRepo.save(r4); // data saved in database
		List<Restaurant>restaurantList = (List<Restaurant>) restaurantRepo.findAll(); 
		
	}
	
	
	
	

}
