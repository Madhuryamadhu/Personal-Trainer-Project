package com.mp.PhysicalTrainerV1.mapper;

import java.util.ArrayList;
import java.util.Date;

import com.mp.PhysicalTrainerV1.entities.ContactEntity;
import com.mp.PhysicalTrainerV1.request.ContactRequest;
import com.mp.PhysicalTrainerV1.response.ContactResponse;
import com.mp.common.codes.MessageCode;

public final class ContactMapper {

	private ContactMapper() {}
	
	public static ContactResponse toContactResponse(ContactEntity entity,MessageCode messageCode) {
		ContactResponse response=new ContactResponse(messageCode);
		
		ArrayList<ContactEntity> contactList=new ArrayList<>();
		ContactEntity contact=new ContactEntity();
		contact.setContactId(entity.getContactId());
		contact.setContactName(entity.getContactName());
		contact.setContactMobile(entity.getContactMobile());
		contact.setContactEmail(entity.getContactEmail());
		contact.setContactDescription(entity.getContactDescription());
		contact.setCreateDate(entity.getCreateDate());
		contact.setContactStatus(entity.getContactStatus());
		contactList.add(contact);
		response.setContacts(contactList);
		
		
		return response;
	}
	
	public static ContactEntity fromContactRequest(ContactRequest request) {
		ContactEntity entity=new ContactEntity();
		
		entity.setContactName(request.getContactName());
		entity.setContactMobile(request.getContactMobile());
		entity.setContactEmail(request.getContactEmail());
		entity.setContactDescription(request.getContactDescription());
		entity.setCreateDate(new Date());
		entity.setContactStatus(request.getContactStatus());
		
		return entity;
	}
}
