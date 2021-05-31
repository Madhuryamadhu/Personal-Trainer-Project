package com.mp.PhysicalTrainerV1.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="contact_details")
public class Contact {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CONTACT_ID")
	private int contactId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CONTACT_FROM_TYPE", referencedColumnName = "CONTACT_FROM_TYPE_ID")
	private ContactFromType contactFromType;

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

	public ContactFromType getContactFromType() {
		return contactFromType;
	}

	public void setContactFromType(ContactFromType contactFromType) {
		this.contactFromType = contactFromType;
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

	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", contactFromType=" + contactFromType + ", contactName="
				+ contactName + ", contactMobile=" + contactMobile + ", contactEmail=" + contactEmail
				+ ", contactDescription=" + contactDescription + ", contactStatus=" + contactStatus + ", createDate="
				+ createDate + "]";
	}
	
	
	
}
