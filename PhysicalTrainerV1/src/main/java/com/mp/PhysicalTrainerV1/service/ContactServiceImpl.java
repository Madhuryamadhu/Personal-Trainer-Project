package com.mp.PhysicalTrainerV1.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mp.PhysicalTrainerV1.entities.ContactEntity;
import com.mp.PhysicalTrainerV1.exceptions.ErrorCodeException;
import com.mp.PhysicalTrainerV1.repository.ContactRepository;
import com.mp.common.codes.ErrorCode;

@Service
public class ContactServiceImpl implements ContactService{

	@Autowired
	private ContactRepository contactRepository;

	@Override
	public ContactEntity saveContact(ContactEntity entity) throws ErrorCodeException {
		
		Optional<ContactEntity> optContactEntityEmail = contactRepository.findByContactEmail(entity.getContactEmail());
		if (optContactEntityEmail.isPresent()) {
			throw new ErrorCodeException(ErrorCode.CONTACT_ALREADY_EXIST_WITH_EMAIL);
		}
		
		Optional<ContactEntity> optContactEntityMobile = contactRepository.findByContactMobile(entity.getContactMobile());
		if (optContactEntityMobile.isPresent()) {
			throw new ErrorCodeException(ErrorCode.CONTACT_ALREADY_EXIST_WITH_MOBILE);
		}
		//TODO COMPLETED--do validation check for email and mobile number(use optional). Create ErrorCOdeException class and throw the error
		ContactEntity created=contactRepository.saveAndFlush(entity);
		return created;
	}



}
