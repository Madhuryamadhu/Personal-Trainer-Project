package com.mp.PhysicalTrainerV1.response;

import java.util.ArrayList;
import java.util.List;

import com.mp.PhysicalTrainerV1.common.BaseResponse;
import com.mp.PhysicalTrainerV1.entities.ContactEntity;
import com.mp.common.codes.MessageCode;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactResponse extends BaseResponse {

	private List<ContactEntity> contacts=new ArrayList<ContactEntity>();
	private long totalLocationsCount;
	
	
	public ContactResponse(MessageCode messageCode) {
		super(messageCode);
	}
	
	
}
