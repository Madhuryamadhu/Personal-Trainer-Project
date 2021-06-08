package com.mp.PhysicalTrainerV1.exceptions;

import org.slf4j.ext.XLogger;
import org.slf4j.ext.XLoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.mp.PhysicalTrainerV1.exceptions.ValidationErrorResponse.Violation;
import com.mp.common.codes.ErrorCode;


@ControllerAdvice
@Order(0)
public class GlobalExceptionHandler {
	private XLogger logger = XLoggerFactory.getXLogger(GlobalExceptionHandler.class.getName());


	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ValidationErrorResponse handleMethodArgumentNotValidException(
			MethodArgumentNotValidException e) {
		logger.error("request failed with MethodArgumentNotValidException", e);
		ValidationErrorResponse error = new ValidationErrorResponse();
		for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
			error
			.getViolations()
			.add(new Violation(fieldError.getField(), fieldError.getDefaultMessage()));
		}
		return error;
	}


	@ExceptionHandler(ErrorCodeException.class)
	public ResponseEntity<ErrorCode> handleErrorCodeException(ErrorCodeException e) {
		logger.error("request failed with ErrorCode", e);
		return ResponseEntity.status(e.getErrorCode().getStatus()).body(e.getErrorCode());
	}
}
