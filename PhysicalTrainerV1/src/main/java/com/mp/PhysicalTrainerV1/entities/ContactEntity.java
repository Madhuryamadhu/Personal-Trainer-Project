package com.mp.PhysicalTrainerV1.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="contact_details")
public class ContactEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CONTACT_ID")
	private int contactId;

	@Column(name="CONTACT_NAME")
	private String contactName;

	@Column(name="CONTACT_MOBILE")
	private String contactMobile;

	@Column(name="CONTACT_EMAIL")
	private String contactEmail;

	@Column(name="CONTACT_DESCRIPTION")
	private String contactDescription;

	@Column(name="CONTACT_STATUS")
	private int contactStatus;

	@Column(name="CREATE_DATE")
	private Date createDate;

	
	
	public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactMobile() {
		return contactMobile;
	}

	public void setContactMobile(String contactMobile) {
		this.contactMobile = contactMobile;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getContactDescription() {
		return contactDescription;
	}

	public void setContactDescription(String contactDescription) {
		this.contactDescription = contactDescription;
	}

	public int getContactStatus() {
		return contactStatus;
	}

	public void setContactStatus(int contactStatus) {
		this.contactStatus = contactStatus;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
}
