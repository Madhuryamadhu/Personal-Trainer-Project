package com.mp.PhysicalTrainerV1.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.ext.XLogger;
import org.slf4j.ext.XLoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mp.PhysicalTrainerV1.entities.ContactEntity;
import com.mp.PhysicalTrainerV1.mapper.ContactMapper;
import com.mp.PhysicalTrainerV1.request.ContactRequest;
import com.mp.PhysicalTrainerV1.response.ContactResponse;
import com.mp.PhysicalTrainerV1.service.ContactService;
import com.mp.common.codes.MessageCode;

@RestController
@RequestMapping("contact")
@CrossOrigin
public class ContactController {

	private XLogger logger = XLoggerFactory.getXLogger(ContactController.class.getName());

	private static final String BEGIN_REQUEST_LOG = "%s request";

	@Autowired
	private ContactService contactService;


	@Autowired
	public ContactController(ContactService theContactService) {
		contactService=theContactService;
	}


	@PostMapping
	public ContactResponse createContact(@Valid @RequestBody ContactRequest request,HttpServletRequest httpRequest) throws Exception{
		logger.entry(String.format(BEGIN_REQUEST_LOG, httpRequest.getRequestURI()));

		ContactEntity entity=ContactMapper.fromContactRequest(request);
		ContactEntity created=contactService.saveContact(entity);

		logger.exit(String.format("locationId=%s", created.getContactId()));
		return ContactMapper.toContactResponse(created, MessageCode.CREATE_CONTACT_SUCCESS);
	}
	
	@GetMapping
	public ResponseEntity<ContactResponse> getContacts(  @RequestParam(defaultValue = "10") Integer limit,
		      @RequestParam(defaultValue = "0") Integer offset,
		      @RequestParam(defaultValue = "contactId") String sortBy,
		      @RequestParam(defaultValue = "asc") String sortDirection,
		      @RequestParam(name="searchTerm",required = false) String searchTerm,
		      HttpServletRequest requestO){
		
		ContactResponse response=contactService.getContacts(sortBy, limit, offset, sortDirection, searchTerm);
		return ResponseEntity.status(response.getHttpStatusCode()).body(response);
	}
	
}
