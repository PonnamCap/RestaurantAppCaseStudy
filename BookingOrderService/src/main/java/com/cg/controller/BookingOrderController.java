package com.cg.controller;

import java.util.List;



import java.util.Optional;

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

import com.cg.exception.OrderAlreadyExists;
import com.cg.exception.OrderIdNotFound;
import com.cg.model.BookingOrder;
import com.cg.repository.BookingOrderRepository;
import com.cg.service.OrderService;

@RestController
@RequestMapping("/api/v1")
public class BookingOrderController {
	
	@Autowired
	private BookingOrderRepository bookrepository;
	
	@Autowired
	private OrderService orderServ;
	
	
	@PostMapping("/addOrder")
	public ResponseEntity<BookingOrder>addBookingOrder(@RequestBody BookingOrder order) throws OrderAlreadyExists {
		BookingOrder savedorder = orderServ.addBookingOrder(order);
		return new ResponseEntity<>(savedorder, HttpStatus.CREATED);
		
	}


	/*@PostMapping("/addOrder")
	public String saveBook(@RequestBody BookingOrder book) throws OrderAlreadyExists {
	bookrepository.save(book);
	return "Booked item with id :  " + book.getId();
    }*/
	@GetMapping("/{id}")
	public Optional<BookingOrder> getBook(@PathVariable String id){
		return bookrepository.findById(id);
	}
	@GetMapping("/findallOrders")
    public List<BookingOrder> getBookingOrder(){
        return bookrepository.findAll();
       
    }
	@PutMapping("/update/{id}")
	public BookingOrder 
	updateBookingOrder(@PathVariable("id") String id,@RequestBody BookingOrder order ) throws OrderIdNotFound {
		return orderServ.updateBookingOrder(order,id);
	}
		
	 @DeleteMapping("/del/{id}")
	 public ResponseEntity<Void> deleteEmployeeById(@PathVariable String id) throws OrderIdNotFound   {
		 orderServ.deleteBookingOrderByid(id);
			return ResponseEntity.noContent().build();
	}

	 
}
