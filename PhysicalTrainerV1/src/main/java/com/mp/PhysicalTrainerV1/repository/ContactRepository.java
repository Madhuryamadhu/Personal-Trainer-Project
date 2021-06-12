package com.mp.PhysicalTrainerV1.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mp.PhysicalTrainerV1.entities.ContactEntity;

@Repository
public interface ContactRepository extends JpaRepository<ContactEntity, String>{

	Optional<ContactEntity> findByContactEmail(String contactEmail);

	Optional<ContactEntity> findByContactMobile(String contactMobile);

	@Query(value ="SELECT * FROM contact_details WHERE LOWER(contact_name) LIKE %:searchTerm% OR LOWER(contact_email) LIKE %:searchTerm% OR LOWER(contact_mobile) LIKE %:searchTerm% LIMIT :limit OFFSET :offset ",nativeQuery = true)
	public List<ContactEntity> findAll(Integer limit, Integer offset, String searchTerm);

}
