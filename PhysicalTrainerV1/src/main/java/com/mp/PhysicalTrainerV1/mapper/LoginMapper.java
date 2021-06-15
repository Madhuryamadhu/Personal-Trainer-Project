package com.mp.PhysicalTrainerV1.mapper;

import com.mp.PhysicalTrainerV1.entities.UserCredentialsEntity;
import com.mp.PhysicalTrainerV1.request.LoginRequest;
import com.mp.PhysicalTrainerV1.response.LoginResponse;
import com.mp.common.codes.MessageCode;

public final class LoginMapper {

	private LoginMapper() {}
	
	public static UserCredentialsEntity fromLoginRequest(LoginRequest request) {
		UserCredentialsEntity entity=new UserCredentialsEntity();
		entity.setUserName(request.getUser_name());
		entity.setPassword(request.getPassword());
		return entity;
	}

	public static LoginResponse toLoginResponse(UserCredentialsEntity entity,MessageCode messageCode) {
		LoginResponse response=new LoginResponse(messageCode);
		return response;
	}
}
