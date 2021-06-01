package com.mp.PhysicalTrainerV1.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.mp.PhysicalTrainerV1.dao.ContactDAO;
import com.mp.PhysicalTrainerV1.entities.Contact;

@Service
public class ContactServiceImpl implements ContactService {

	private ContactDAO contactDao;
	
	public ContactServiceImpl(ContactDAO theContactDao) {
		contactDao=theContactDao;
	}
	
	@Override
	@Transactional
	public void saveContact(Contact contact) {
		contactDao.save(contact);

	}

}
