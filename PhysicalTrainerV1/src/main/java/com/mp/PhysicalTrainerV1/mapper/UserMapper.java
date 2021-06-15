package com.mp.PhysicalTrainerV1.mapper;

import java.util.Date;

import com.mp.PhysicalTrainerV1.entities.UserEntity;
import com.mp.PhysicalTrainerV1.request.CreateUserRequest;
import com.mp.PhysicalTrainerV1.response.CreateUserResponse;
import com.mp.common.codes.MessageCode;

public final class UserMapper {

	private UserMapper() {}
	
	public static CreateUserResponse toContactResponse(UserEntity entity,MessageCode messageCode) {
		CreateUserResponse response=new CreateUserResponse(messageCode);
		return response;
	}
	
	
	public static UserEntity fromContactRequest(CreateUserRequest request) {
		UserEntity entity=new UserEntity();
		entity.setFullName(request.getFull_name());
		entity.setPhoneNumber(request.getPhone_number());
		entity.setEmail(request.getEmail_id());
		entity.setCreateDate(new Date());
		return entity;
	}

}
