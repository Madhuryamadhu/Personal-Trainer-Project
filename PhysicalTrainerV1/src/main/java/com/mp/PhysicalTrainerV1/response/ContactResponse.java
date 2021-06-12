package com.mp.PhysicalTrainerV1.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.mp.PhysicalTrainerV1.common.BaseResponse;
import com.mp.PhysicalTrainerV1.entities.ContactEntity;
import com.mp.common.codes.MessageCode;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactResponse extends BaseResponse {

	@JsonInclude(Include.NON_NULL)
	private List<ContactEntity> contacts;
	private long totalLocationsCount;


	public ContactResponse(MessageCode messageCode) {
		super(messageCode);
	}

	public ContactResponse(MessageCode messageCode,List<ContactEntity> contacts) {
		super(messageCode);
		this.contacts=contacts;
		totalLocationsCount=contacts.size();
	}
	
	
}
