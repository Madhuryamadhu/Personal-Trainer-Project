package com.mp.PhysicalTrainerV1.request;

import static com.mp.common.Constants.EMAIL_LENGTH;
import static com.mp.common.Constants.MOBILE_NUMBER_LENGTH;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateUserRequest {

	@NotBlank
	private String full_name;
	
	@NotBlank
	@Size(max = MOBILE_NUMBER_LENGTH)
	private String phone_number;
	
	@NotBlank
	@Size(max = EMAIL_LENGTH)
	@Email
	private String email_id;

	public CreateUserRequest(String full_name,String phone_number,String email_id) {
		super();
		this.full_name = full_name;
		this.phone_number = phone_number;
		this.email_id = email_id;
	}
}
