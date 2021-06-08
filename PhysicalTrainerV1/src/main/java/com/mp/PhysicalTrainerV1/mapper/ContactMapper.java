package com.mp.PhysicalTrainerV1.mapper;

import static com.mp.common.Constants.CONTACT_INIT_STATUS;

import java.util.Date;
import com.mp.PhysicalTrainerV1.entities.ContactEntity;
import com.mp.PhysicalTrainerV1.request.ContactRequest;
import com.mp.PhysicalTrainerV1.response.ContactResponse;
import com.mp.common.codes.MessageCode;

public final class ContactMapper {

	private ContactMapper() {}
	
	public static ContactResponse toContactResponse(ContactEntity entity,MessageCode messageCode) {
		ContactResponse response=new ContactResponse(messageCode);
		return response;
	}
	
	public static ContactEntity fromContactRequest(ContactRequest request) {
		ContactEntity entity=new ContactEntity();
		
		entity.setContactName(request.getContactName());
		entity.setContactMobile(request.getContactMobile());
		entity.setContactEmail(request.getContactEmail());
		entity.setContactDescription(request.getContactDescription());
		entity.setCreateDate(new Date());
		
		//TODO COMEPLETED--take this from constant class
		entity.setContactStatus(CONTACT_INIT_STATUS);
		
		return entity;
	}
}
