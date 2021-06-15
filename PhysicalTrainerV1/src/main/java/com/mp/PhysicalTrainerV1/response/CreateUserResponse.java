package com.mp.PhysicalTrainerV1.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.mp.PhysicalTrainerV1.common.BaseResponse;
import com.mp.PhysicalTrainerV1.entities.UserEntity;
import com.mp.common.codes.MessageCode;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserResponse extends BaseResponse  {

	@JsonInclude(Include.NON_NULL)
	private List<UserEntity> users;
	private long totalLocationsCount;
	
	public CreateUserResponse(MessageCode messageCode) {
		super(messageCode);
	}

	public CreateUserResponse(MessageCode messageCode,List<UserEntity> users) {
		super(messageCode);
		this.users=users;
		totalLocationsCount=users.size();
	}
}
