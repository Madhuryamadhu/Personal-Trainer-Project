package com.mp.PhysicalTrainerV1.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ContactRequest {

	private String contactName;

	private String contactMobile;

	private String contactEmail;

	private String contactDescription;

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
