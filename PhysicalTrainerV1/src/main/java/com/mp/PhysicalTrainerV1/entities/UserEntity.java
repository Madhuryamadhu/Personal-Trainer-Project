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

@Getter
@Setter
@Entity
@Table(name="user_details")
public class UserEntity {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "USER_ID", updatable = false, nullable = false)
	private String id;
	
	@Column(name="FULL_NAME")
	private String fullName;
	
	@Column(name="PHONE_NUMBER")
	private String phoneNumber;
	
	@Column(name="EMAIL_ID")
	private String email;
	
	@Column(name="IS_ACTIVE")
	private int isActive;
	
	@Column(name="CREATE_DATE")
	private Date createDate;
	
	@Column(name="ACTIVATION_DATE")
	private Date activationDate;
}
