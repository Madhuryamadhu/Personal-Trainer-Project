package com.mp.PhysicalTrainerV1.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.mp.PhysicalTrainerV1.entities.UserEntity;

@Repository
public interface UserRepository  extends JpaRepository<UserEntity, String> {

	Optional<UserEntity> findByPhoneNumber(String email);

	Optional<UserEntity> findByEmail(String email);

	@Query(value ="SELECT * FROM user_details WHERE LOWER(full_name) LIKE %:searchTerm% OR LOWER(phone_number) LIKE %:searchTerm% OR LOWER(email_id) LIKE %:searchTerm% LIMIT :limit OFFSET :offset ",nativeQuery = true)
	List<UserEntity> findAll(Integer limit, Integer offset, String searchTerm);

}
