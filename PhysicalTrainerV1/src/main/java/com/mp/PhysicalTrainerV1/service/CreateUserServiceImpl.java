package com.mp.PhysicalTrainerV1.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mp.PhysicalTrainerV1.entities.ContactEntity;
import com.mp.PhysicalTrainerV1.entities.UserEntity;
import com.mp.PhysicalTrainerV1.exceptions.ErrorCodeException;
import com.mp.PhysicalTrainerV1.repository.UserRepository;
import com.mp.PhysicalTrainerV1.response.ContactResponse;
import com.mp.PhysicalTrainerV1.response.CreateUserResponse;
import com.mp.common.codes.ErrorCode;
import com.mp.common.codes.MessageCode;


@Service
public class CreateUserServiceImpl implements CreateUserService {

	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	@Transactional
	public UserEntity createUser(UserEntity entity) {
		
		Optional<UserEntity> optUserEntityEmail = userRepository.findByEmail(entity.getEmail());
		if (optUserEntityEmail.isPresent()) {
			throw new ErrorCodeException(ErrorCode.USER_ALREADY_EXIST_WITH_EMAIL);
		}
		
		Optional<UserEntity> optUserEntityMobile = userRepository.findByPhoneNumber(entity.getPhoneNumber());
		if (optUserEntityMobile.isPresent()) {
			throw new ErrorCodeException(ErrorCode.USER_ALREADY_EXIST_WITH_MOBILE);
		}
		
		UserEntity created=userRepository.saveAndFlush(entity);
		return created;
	}


	@Override
	public CreateUserResponse getContacts(String sortBy, Integer limit, Integer offset, String sortDirection,
			String searchTerm) {
		List<UserEntity> users=userRepository.findAll(limit,offset,searchTerm);
		return new CreateUserResponse(MessageCode.GET_USER_SUCCESS,users);
	}

}
