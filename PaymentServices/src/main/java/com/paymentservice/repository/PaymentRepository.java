package com.paymentservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.paymentservice.entity.PaymentDetails;

public interface PaymentRepository extends MongoRepository <PaymentDetails , Integer> {

}
