package com.cg.controller;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cg.model.Restaurant;
import com.cg.service.RestaurantService;
import com.fasterxml.jackson.databind.ObjectMapper;


@ExtendWith(MockitoExtension.class)
public class RestaurantControllerTest {
	
	@Autowired
	private MockMvc mocMvc;
	
     
	@Mock
	private  RestaurantService rs;
	private  Restaurant r;
	private List< Restaurant> restaurantList;
	
	@InjectMocks
	private  RestaurantController rc;
	
	@BeforeEach
	public void setUp() {
		r = new  Restaurant("121Z", "Classic","Karimnagar","Good");
		mocMvc= MockMvcBuilders.standaloneSetup(rc).build();
	}
	
	
	@Test
	public void RestaurantControllerTest() throws Exception{
		when(rs.addRestaurant(any())).thenReturn(r);
		mocMvc.perform(post("/api/v1/restaurant")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJSONString(r)))
		        .andExpect(status().isCreated());
    	verify(rs,times(1)).addRestaurant(any());

	}

    @Test
    public void getAllRestaurantControllerTest() throws Exception {
    	when(rs.getAllRestaurants()).thenReturn(restaurantList);
    	mocMvc.perform(MockMvcRequestBuilders.get("/api/v1/restaurants")
    	.contentType(MediaType.APPLICATION_JSON)
    	.content(asJSONString(r)))
    	.andDo(MockMvcResultHandlers.print());
    	verify(rs,times(1)).getAllRestaurants();
    	
    	
    }
	
	
	public static String asJSONString(final Object obj) {
		// TODO Auto-generated method stub
		try {
			
		return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}


	

}