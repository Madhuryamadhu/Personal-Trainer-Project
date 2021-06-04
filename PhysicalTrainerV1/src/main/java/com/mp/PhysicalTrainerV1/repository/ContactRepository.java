package com.mp.PhysicalTrainerV1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mp.PhysicalTrainerV1.entities.ContactEntity;

@Repository
public interface ContactRepository extends JpaRepository<ContactEntity, String>{

}
