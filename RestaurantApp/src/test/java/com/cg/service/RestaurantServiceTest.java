package com.cg.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.exception.RestaurantAlreadyExists;
import com.cg.model.Restaurant;
import com.cg.repository.RestaurantRepository;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class RestaurantServiceTest {
	 
	 @Mock
	 private RestaurantRepository rr;
	 
	 @InjectMocks
	 private RestaurantServiceImpl rsl;
	 
	 
	 

	@Test
	public void TestAddRestaurant() throws RestaurantAlreadyExists {
		Restaurant r1 = new Restaurant("12I","Sensations","Kukatpally","Awesome"); //user Input
       when(rr.save(any())).thenReturn(r1);
       rsl.addRestaurant(r1); // Data is saved in Database
       verify(rr,times(1)).save(any());
	}
	
	@Test
	public void testgetAllrestaurants() {
		Restaurant r1 = new Restaurant("12I","Sensations","Kukatpally","Awesome"); //user Input
		Restaurant r2 = new Restaurant("12J","BBQ","Secunderabad","Good"); //user Input
		Restaurant r3 = new Restaurant("12K","Druken Monkey","L.B.Nagar","Awesome"); // user Input
		rr.save(r1);
		rr.save(r2);
		rr.save(r3);
		List<Restaurant>rList = new ArrayList<>(); //  Creating list Object
		rList.add(r1);
		rList.add(r2);
		rList.add(r3);
		
		when(rr.findAll()).thenReturn(rList);
		List<Restaurant> rList1 = rsl.getAllRestaurants();
		assertEquals(rList, rList1);
		verify(rr,times(1)).save(r1);
		verify(rr,times(1)).findAll();
		

	}
	
	
	
	
	
	
}
