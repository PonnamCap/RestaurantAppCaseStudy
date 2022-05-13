package com.cg.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cg.model.Restaurant;

@Repository
public interface RestaurantRepository extends MongoRepository<Restaurant, String>  {

}
