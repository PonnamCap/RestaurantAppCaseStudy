package com.cg.service;


import java.util.List;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.exception.OrderAlreadyExists;
import com.cg.exception.OrderIdNotFound;
import com.cg.model.BookingOrder;
import com.cg.repository.BookingOrderRepository;
@Service
public class OrderServiceImpl implements OrderService {
	
	private BookingOrderRepository orderRepo;

    @Autowired
	public OrderServiceImpl(BookingOrderRepository orderRepo) {
		super();
		this.orderRepo = orderRepo;
	}

	@Override
	public BookingOrder addBookingOrder(BookingOrder order) throws OrderAlreadyExists {
		// TODO Auto-generated method stub
		if(orderRepo.existsById(order.getId())) {
			throw new OrderAlreadyExists();
		}
		BookingOrder savedBookingOrder = orderRepo.save(order);
		return savedBookingOrder;
	}

	@Override
	public List<BookingOrder> getAllBookingOrders()  {
		// TODO Auto-generated method stub
		
		return (List<BookingOrder>) orderRepo.findAll();

	}

	@Override
	public BookingOrder updateBookingOrder(BookingOrder order, String id) throws OrderIdNotFound {
		// TODO Auto-generated method stub
		
		
		Optional<BookingOrder> orderDB =this.orderRepo.findById(order.getId());
		if(orderDB.isPresent()) {
			BookingOrder orderUpdate = orderDB.get();
			orderUpdate.setId(order.getId());
			orderUpdate.setItemName(order.getItemName());
			orderUpdate.setQuantity(order.getQuantity());
		orderRepo.save(order);
		return order;
	}
		else
		{
        throw new OrderIdNotFound(); 
		}
	}
		//if (Objects.nonNull(game.getGameName()) && !"".equalsIgnoreCase(game.getGameName())) { {
	  //  gameDB.setGameName(game.getGameName());
	    
		//}
		
		//if(Objects.nonNull(game.getGameLoc()) && !"".equalsIgnoreCase(game.getGameLoc())) {
		//	gameDB.setGameLoc(game.getGameLoc());
	//	}
		
	//	if(Objects.nonNull(game.getGameCode()) && !"".equalsIgnoreCase(game.getGameCode())) {
	//		gameDB.setGameCode(game.getGameCode());

		//}
	//	return gameRepo.save(gameDB);
	//}
	//else 
	//{
	//	throw new GameIdNotFound();
	//   }
	

	@Override
	public void deleteBookingOrderByid(String id) throws OrderIdNotFound{
		// TODO Auto-generated method stub
	Optional<BookingOrder> orderDB = this.orderRepo.findById(id);
		//gameRepo.deleteById(gameId);
		if(orderDB.isPresent()) { 
			this.orderRepo.delete(orderDB.get());
		}
		else
		{
			throw new OrderIdNotFound();
			
		}
		

	}

}
