package com.mp.PhysicalTrainerV1.service;

import com.mp.PhysicalTrainerV1.entities.ContactEntity;
import com.mp.PhysicalTrainerV1.response.ContactResponse;

public interface ContactService {

	public ContactEntity saveContact(ContactEntity entity);
	
	public ContactResponse getContacts(String userId, Integer limit, Integer offset, String orderByCondition, String searchTerm);
}
