package com.mp.PhysicalTrainerV1.request;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginRequest {

	@NotBlank
	private String user_name;
	
	@NotBlank
	private String password;

	public LoginRequest(@NotBlank String user_name, @NotBlank String password) {
		super();
		this.user_name = user_name;
		this.password = password;
	}

	
	
}
