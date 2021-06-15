package com.mp.PhysicalTrainerV1.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.ext.XLogger;
import org.slf4j.ext.XLoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mp.PhysicalTrainerV1.entities.UserEntity;
import com.mp.PhysicalTrainerV1.mapper.UserMapper;
import com.mp.PhysicalTrainerV1.request.CreateUserRequest;
import com.mp.PhysicalTrainerV1.response.ContactResponse;
import com.mp.PhysicalTrainerV1.response.CreateUserResponse;
import com.mp.PhysicalTrainerV1.service.CreateUserService;
import com.mp.common.codes.MessageCode;

@RestController
@RequestMapping("user")
@CrossOrigin
public class UserController {

	private XLogger logger = XLoggerFactory.getXLogger(UserController.class.getName());

	private static final String BEGIN_REQUEST_LOG = "%s request";
	
	@Autowired
	private CreateUserService createUserService;
	
	
	@PostMapping
	public CreateUserResponse createUser(@Valid @RequestBody CreateUserRequest request,HttpServletRequest httpRequest) {
		logger.entry(String.format(BEGIN_REQUEST_LOG, httpRequest.getRequestURI()));
		
		UserEntity entity=UserMapper.fromContactRequest(request);
		UserEntity created=createUserService.createUser(entity);
		
		logger.exit(String.format("locationId=%s", created.getId()));
		return UserMapper.toContactResponse(created, MessageCode.CREATE_USER_SUCCESS);
	}
	
	@GetMapping
	public ResponseEntity<CreateUserResponse> getUsers(  @RequestParam(defaultValue = "10") Integer limit,
		      @RequestParam(defaultValue = "0") Integer offset,
		      @RequestParam(defaultValue = "userId") String sortBy,
		      @RequestParam(defaultValue = "asc") String sortDirection,
		      @RequestParam(name="searchTerm",required = false) String searchTerm,
		      HttpServletRequest requestO){
		
		CreateUserResponse response=createUserService.getContacts(sortBy, limit, offset, sortDirection, searchTerm);
		return ResponseEntity.status(response.getHttpStatusCode()).body(response);
	}
}
