package com.cg;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.service.ContactService;

import static org.mockito.Mockito.when;

import com.cg.model.Contact;
import com.cg.repository.ContactRepository;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
@RunWith(SpringRunner.class)
class ApplicationContactApplicationTests {
	
	@Autowired
	private ContactService contactService;
	
	@MockBean
	private ContactRepository conatctRepository;

	@Test
	public void getContactTest() {
		when(conatctRepository.findAll()).thenReturn(Stream
				.of(new Contact("12","Tapan","415178261678"), new Contact("69","Riya","123656760")).collect(Collectors.toList()));
		    assertEquals(2,contactService.getContact().size());
	}
		private void assertEquals(int i, int size) {
		// TODO Auto-generated method stub
		
	}
		@Test
		public void saveContactTest() {
			Contact contact = new Contact("999", "Pranya", "431516626262");
			when(conatctRepository.save(contact)).thenReturn(contact);
		    assertEquals(contact, contactService.addContact(contact));
		
		}
		private void assertEquals(Contact contact, Contact addContact) {
			// TODO Auto-generated method stub
			
		}

}
