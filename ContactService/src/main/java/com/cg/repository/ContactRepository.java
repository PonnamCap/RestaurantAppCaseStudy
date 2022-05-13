package com.cg.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.model.Contact;

public interface ContactRepository extends MongoRepository<Contact, String>  {

}
