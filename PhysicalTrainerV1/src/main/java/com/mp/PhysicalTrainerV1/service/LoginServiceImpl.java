package com.mp.PhysicalTrainerV1.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mp.PhysicalTrainerV1.entities.UserCredentialsEntity;
import com.mp.PhysicalTrainerV1.exceptions.ErrorCodeException;
import com.mp.PhysicalTrainerV1.repository.LoginRepository;
import com.mp.common.codes.ErrorCode;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginRepository repository;
	
	@Override
	@Transactional
	public UserCredentialsEntity login(UserCredentialsEntity entity) {
	
		Optional<UserCredentialsEntity> optUserCredentialsEntityUserName = repository.findByUserName(entity.getUserName());
		if (!optUserCredentialsEntityUserName.isPresent()) {
			throw new ErrorCodeException(ErrorCode.LOGIN_WRONG_USERNAME);
		}
		
		Optional<UserCredentialsEntity> optUserCredentialsEntityPassword = repository.findByUserNameAndPassword(entity.getUserName(),entity.getPassword());
		if (!optUserCredentialsEntityPassword.isPresent()) {
			throw new ErrorCodeException(ErrorCode.LOGIN_WRONG_PASSWORD);
		}
		
		return entity;
	}

}
