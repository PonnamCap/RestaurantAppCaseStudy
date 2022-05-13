package com.cg.model.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cg.model.Menu;

@Repository
public interface MenuRepository extends MongoRepository<Menu, String>{

}
