package com.mp.PhysicalTrainerV1.request;

import static com.mp.common.Constants.EMAIL_LENGTH;
import static com.mp.common.Constants.MOBILE_NUMBER_LENGTH;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
public class ContactRequest {




	//TODO COMEPLETED--add validations (Refer - UserRequest.java)
	@NotBlank
	private String contactName;

	@ToString.Exclude
	@NotBlank
	@Size(max = MOBILE_NUMBER_LENGTH)
	private String contactMobile;

	@ToString.Exclude
	@NotBlank
	@Size(max = EMAIL_LENGTH)
	@Email
	private String contactEmail;

	private String contactDescription;
	
	//TODO COMEPLETED--ignore this in create request  
	@JsonIgnore
	private int contactStatus;


	//Constructor
	public ContactRequest(String contactName, String contactMobile, String contactEmail, String contactDescription,
			int contactStatus) {
		super();
		this.contactName = contactName;
		this.contactMobile = contactMobile;
		this.contactEmail = contactEmail;
		this.contactDescription = contactDescription;
		this.contactStatus = contactStatus;
	}




}
