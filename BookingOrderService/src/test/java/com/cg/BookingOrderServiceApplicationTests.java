package com.cg;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.model.BookingOrder;
import com.cg.repository.BookingOrderRepository;
import com.cg.service.OrderService;

import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
@RunWith(SpringRunner.class)
class ApplicationContactApplicationTests {
	
	@Autowired
	private OrderService orderService;
	
	@MockBean
	private BookingOrderRepository orderRepo;

	@Test
	public void getBookingOrderTest() {
		when(orderRepo.findAll()).thenReturn(Stream
				.of(new BookingOrder("12","Chicekn Biryani","1"), new BookingOrder("123","Panner Biryani","2")).collect(Collectors.toList()));
		    assertEquals(2,orderService.getAllBookingOrders().size());
	}
		private void assertEquals(int i, int size) {
		// TODO Auto-generated method stub
		
	}
		@Test
		public void saveBookingOrderTest() {
			BookingOrder order = new BookingOrder("123", "Panner Biryani", "2");
			when(orderRepo.save(order)).thenReturn(order);
		
		}

}