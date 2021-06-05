package com.mp.PhysicalTrainerV1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mp.PhysicalTrainerV1.entities.ContactEntity;
import com.mp.PhysicalTrainerV1.mapper.ContactMapper;
import com.mp.PhysicalTrainerV1.request.ContactRequest;
import com.mp.PhysicalTrainerV1.response.ContactResponse;
import com.mp.PhysicalTrainerV1.service.ContactService;
import com.mp.common.codes.MessageCode;

@RestController
@RequestMapping("contact")
public class ContactController {

	@Autowired
	private ContactService contactService;
	
	
	@Autowired
	public ContactController(ContactService theContactService) {
		contactService=theContactService;
	}
	
	
	
	
	@PostMapping()
	public ContactResponse createContact(@RequestBody ContactRequest request) {
		
		
		ContactEntity entity=ContactMapper.fromContactRequest(request);
		ContactEntity created=contactService.saveContact(entity);
		
		return ContactMapper.toContactResponse(created, MessageCode.CREATE_CONTACT_SUCCESS);
	}
}
