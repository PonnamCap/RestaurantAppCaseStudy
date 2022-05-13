package com.cg.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.model.BookingOrder;

public interface BookingOrderRepository extends MongoRepository<BookingOrder, String>  {

}
