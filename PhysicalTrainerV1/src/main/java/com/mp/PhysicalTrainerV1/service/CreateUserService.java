package com.mp.PhysicalTrainerV1.service;

import org.springframework.stereotype.Service;

import com.mp.PhysicalTrainerV1.entities.UserEntity;
import com.mp.PhysicalTrainerV1.response.CreateUserResponse;

public interface CreateUserService {

	public UserEntity createUser(UserEntity entity);

	public CreateUserResponse getContacts(String sortBy, Integer limit, Integer offset, String sortDirection,
			String searchTerm);
}
