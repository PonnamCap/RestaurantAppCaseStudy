package com.cg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.exception.OrderAlreadyExists;
import com.cg.exception.OrderIdNotFound;
import com.cg.model.BookingOrder;

@Service
public interface OrderService  {
	
	
	public BookingOrder addBookingOrder(BookingOrder order) throws OrderAlreadyExists;
	public List<BookingOrder> getAllBookingOrders()  ;
	BookingOrder updateBookingOrder(BookingOrder order, String id) throws OrderIdNotFound;
	public void deleteBookingOrderByid(String id) throws OrderIdNotFound;
}
