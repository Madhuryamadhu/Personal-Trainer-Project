package com.mp.PhysicalTrainerV1.response;

import com.mp.PhysicalTrainerV1.common.BaseResponse;
import com.mp.common.codes.MessageCode;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponse  extends BaseResponse {
	
	public LoginResponse(MessageCode messageCode) {
		super(messageCode);
	}
}
