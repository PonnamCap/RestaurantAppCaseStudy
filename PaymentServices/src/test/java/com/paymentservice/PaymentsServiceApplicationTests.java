package com.paymentservice;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.paymentservice.entity.PaymentDetails;
import com.paymentservice.repository.PaymentRepository;
import com.paymentservice.service.PaymentService;

@RunWith(SpringRunner.class)
@SpringBootTest
class PaymentsServiceApplicationTests {


	@Autowired
	private PaymentService service;
	@MockBean
	private PaymentRepository repository;
	
	@Test
	public void doPayTest()
	{
		PaymentDetails payment=new PaymentDetails(2,214,"success","123654");
		when(repository.save(payment)).thenReturn(payment);
		assertEquals(payment,service.doPay(payment));
	}

}
