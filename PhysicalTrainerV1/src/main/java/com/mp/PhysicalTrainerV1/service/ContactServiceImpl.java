package com.mp.PhysicalTrainerV1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mp.PhysicalTrainerV1.entities.ContactEntity;
import com.mp.PhysicalTrainerV1.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService{

	@Autowired
	private ContactRepository contactRepository;

	@Override
	public ContactEntity saveContact(ContactEntity entity) {
		ContactEntity created=contactRepository.saveAndFlush(entity);
		return created;
	}
	
	
	
}
