package com.mp.PhysicalTrainerV1.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mp.PhysicalTrainerV1.entities.UserCredentialsEntity;

@Repository
public interface LoginRepository extends JpaRepository<UserCredentialsEntity, String> {

	Optional<UserCredentialsEntity> findByUserName(String userName);

	Optional<UserCredentialsEntity> findByUserNameAndPassword(String userName, String password);

}
