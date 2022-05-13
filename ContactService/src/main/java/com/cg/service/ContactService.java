package com.cg.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.model.Contact;
import com.cg.repository.ContactRepository;



@Service
public class ContactService {

	@Autowired
	private ContactRepository contactrepository;
	

	public Contact addContact (Contact contact) {
		return contactrepository.save(contact);
	}

	public List<Contact> getContact() {
		List<Contact> contact = contactrepository.findAll();
		System.out.println("Getting data from DB : " + contact);
		return contact;
	}

	public Optional<Contact> getContactbyId(String id) {
		return contactrepository.findById(id);
	}

	public void deleteContact(Contact contact) {
		contactrepository.delete(contact);
	}


}
