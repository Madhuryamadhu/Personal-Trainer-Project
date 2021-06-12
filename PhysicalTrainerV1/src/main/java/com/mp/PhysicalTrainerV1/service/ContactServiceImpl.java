package com.mp.PhysicalTrainerV1.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mp.PhysicalTrainerV1.entities.ContactEntity;
import com.mp.PhysicalTrainerV1.exceptions.ErrorCodeException;
import com.mp.PhysicalTrainerV1.repository.ContactRepository;
import com.mp.PhysicalTrainerV1.response.ContactResponse;
import com.mp.common.codes.ErrorCode;
import com.mp.common.codes.MessageCode;

@Service
public class ContactServiceImpl implements ContactService{

	@Autowired
	private ContactRepository contactRepository;

	@Override
	@Transactional
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

	@Override
	@Transactional
	public ContactResponse getContacts(String userId, Integer limit, Integer offset, String orderByCondition,
			String searchTerm) {
		List<ContactEntity> contacts=contactRepository.findAll(limit,offset,searchTerm);
		return new ContactResponse(MessageCode.GET_CONTACT_SUCCESS,contacts);
	}



}
