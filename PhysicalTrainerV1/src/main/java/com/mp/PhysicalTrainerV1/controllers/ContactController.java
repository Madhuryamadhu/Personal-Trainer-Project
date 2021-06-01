package com.mp.PhysicalTrainerV1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mp.PhysicalTrainerV1.entities.Contact;
import com.mp.PhysicalTrainerV1.service.ContactService;

@RestController
@RequestMapping("contact")
public class ContactController {

	private ContactService contactService;
	
	@Autowired
	public ContactController(ContactService theContactService) {
		contactService=theContactService;
	}
	
	@PostMapping
	public Contact createContact(@RequestBody Contact contact) {
		
		contact.setContactId(0);
		
		contactService.saveContact(contact);
		
		return contact;
	}
}
