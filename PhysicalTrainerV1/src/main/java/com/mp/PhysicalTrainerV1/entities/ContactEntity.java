package com.mp.PhysicalTrainerV1.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;

//TODO try to create table from entity and add validation
@Getter
@Setter
@Entity
@Table(name="contact_details")
public class ContactEntity {

	//TODO COMEPLETED--change column name to id
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "id", updatable = false, nullable = false)
	private String contactId;

	@Column(name="CONTACT_NAME",nullable=false,length=255)
	private String contactName;

	@Column(name="CONTACT_MOBILE",nullable=false,length=10,unique = true)
	private String contactMobile;

	@Column(name="CONTACT_EMAIL",nullable=false,length=30,unique = true)
	private String contactEmail;

	@Column(name="CONTACT_DESCRIPTION",length=1000)
	private String contactDescription;

	@Column(name="CONTACT_STATUS")
	private int contactStatus;

	@Column(name="CREATE_DATE")
	private Date createDate;

}
