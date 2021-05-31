package com.mp.PhysicalTrainerV1.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mp.PhysicalTrainerV1.entities.Contact;



@Repository
public class ContactDAOImpl implements ContactDAO {
	
	private EntityManager entityManager;

	@Autowired
	public ContactDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public void save(Contact contact) {
		Contact dbContact=entityManager.merge(contact);
		
		contact.setContactId(dbContact.getContactId());

	}

}
