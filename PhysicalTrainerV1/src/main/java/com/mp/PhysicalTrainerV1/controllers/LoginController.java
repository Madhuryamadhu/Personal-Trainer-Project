package com.mp.PhysicalTrainerV1.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.ext.XLogger;
import org.slf4j.ext.XLoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mp.PhysicalTrainerV1.entities.ContactEntity;
import com.mp.PhysicalTrainerV1.entities.UserCredentialsEntity;
import com.mp.PhysicalTrainerV1.mapper.ContactMapper;
import com.mp.PhysicalTrainerV1.mapper.LoginMapper;
import com.mp.PhysicalTrainerV1.request.ContactRequest;
import com.mp.PhysicalTrainerV1.request.LoginRequest;
import com.mp.PhysicalTrainerV1.response.ContactResponse;
import com.mp.PhysicalTrainerV1.response.LoginResponse;
import com.mp.PhysicalTrainerV1.service.LoginService;
import com.mp.common.codes.MessageCode;

@RestController
@RequestMapping("login")
@CrossOrigin
public class LoginController {

	private XLogger logger = XLoggerFactory.getXLogger(LoginController.class.getName());

	private static final String BEGIN_REQUEST_LOG = "%s request";

	@Autowired
	private LoginService loginService;


	@PostMapping 
	public LoginResponse login(@Valid @RequestBody LoginRequest request,HttpServletRequest httpRequest) throws Exception{
		logger.entry(String.format(BEGIN_REQUEST_LOG, httpRequest.getRequestURI()));

		UserCredentialsEntity entity=LoginMapper.fromLoginRequest(request); 
		UserCredentialsEntity created=loginService.login(entity);

		logger.exit(String.format("locationId=%s", created.getId())); 
		return LoginMapper.toLoginResponse(created, MessageCode.LOGIN_SUCCESS);
	}

}
