package com.mp.PhysicalTrainerV1.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="contact_from_type_details")
public class ContactFromType {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CONTACT_FROM_TYPE_ID")
	private int contactFromTypeId;
	
	@Column(name="CONTACT_FROM_TYPE_NAME")
	private int contactFromTypeName;
	
	@Column(name="CREATE_DATE")
	private Date createDate;

	
	
	public int getContactFromTypeId() {
		return contactFromTypeId;
	}

	public void setContactFromTypeId(int contactFromTypeId) {
		this.contactFromTypeId = contactFromTypeId;
	}

	public int getContactFromTypeName() {
		return contactFromTypeName;
	}

	public void setContactFromTypeName(int contactFromTypeName) {
		this.contactFromTypeName = contactFromTypeName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "ContactFromType [contactFromTypeId=" + contactFromTypeId + ", contactFromTypeName="
				+ contactFromTypeName + ", createDate=" + createDate + "]";
	}
	
	
	
	
	
	
}
