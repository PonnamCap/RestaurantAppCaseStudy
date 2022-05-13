package com.paymentservice.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paymentservice.entity.PaymentDetails;
import com.paymentservice.service.PaymentService;

@RestController
@RequestMapping("/dopay")
public class PaymentController {
	@Autowired
    public PaymentService service;

    @PostMapping("/payment")
    public PaymentDetails doPayment(@RequestBody PaymentDetails payment){
        return service.doPay(payment);
    }

}
