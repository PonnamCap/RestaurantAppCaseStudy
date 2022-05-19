package com.cg.controller;


import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.model.Contact;
import com.cg.repository.ContactRepository;


@RestController
@RequestMapping("/api/v1")
public class ContactController {
	
	@Autowired
	private ContactRepository contactrepository;
	//adds contact
	@PostMapping("/addContact")
	public String saveContact(@RequestBody Contact contact) {
    contactrepository.save(contact);
	return "Added contact with id :  " + contact.getId();
}
	//finds the contct by given id
	@GetMapping("/findAllContacts")
	public List<Contact> getContacts(){
		return contactrepository.findAll();
		
	}
	//finds the contact by given id
	@GetMapping("/findAllContacts/{id}")
	public Optional<Contact> getContact(@PathVariable String id){
		return contactrepository.findById(id);
	}
	//updates the contact by given id
	@PutMapping("/update/{id}")
	public Contact updateContact(@PathVariable("id") String id,@RequestBody Contact contact ) {
		contact.setId(id);
		contactrepository.save(contact);
		return contact;
	}
	//deletes the contact by given id
	 @DeleteMapping("/delcontact/{id}")
		public String deleteContact (@PathVariable String id) {
			contactrepository.deleteById(id);
			return "Contact deleted with id : "+id;
		}
	 
	//gets the contact
	 @GetMapping("/Contact")
		public Contact getContactData() {
		 Contact ct = new Contact ("1","Sai","7680089900" );
			return ct;
	}
	 
}
