package com.mp.common.codes;

import java.io.IOException;
import java.time.Instant;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
@JsonSerialize(using = ErrorCode.ErrorCodeSerializer.class)
public enum ErrorCode {

	CONTACT_ALREADY_EXIST_WITH_EMAIL(
			400,
			"EC_0001",
			Constants.BAD_REQUEST,
			"Contact request already submitted from this mail."),
	CONTACT_ALREADY_EXIST_WITH_MOBILE(
			400,
			"EC_0002",
			Constants.BAD_REQUEST,
			"Contact request already submitted from this mobile number."),
	USER_ALREADY_EXIST_WITH_EMAIL(
			400,
			"EC_0003",
			Constants.BAD_REQUEST,
			"User request already submitted from this mail."),
	USER_ALREADY_EXIST_WITH_MOBILE(
			400,
			"EC_0004",
			Constants.BAD_REQUEST,
			"User request already submitted from this mobile number."),
	LOGIN_WRONG_USERNAME(
			400,
			"EC_0005",
			Constants.BAD_REQUEST,
			"Username entered is not correct.Please check it"),
	LOGIN_WRONG_PASSWORD(
			400,
			"EC_0006",
			Constants.BAD_REQUEST,
			"Username and password are not matching. Please check it");

	private final int status;
	private final String code;
	private final String errorType;
	private final String description;

	public static ErrorCode fromCodeAndDescription(String code, String description) {
		for (ErrorCode e : ErrorCode.values()) {
			if (StringUtils.equalsIgnoreCase(e.code, code)
					&& StringUtils.equalsIgnoreCase(e.description, description)) {
				return e;
			}
		}
		return null; // not found
	}

	private static class Constants {

		private static final String BAD_REQUEST = "Bad Request";
	}

	static class ErrorCodeSerializer extends StdSerializer<ErrorCode> {

		private static final long serialVersionUID = 1L;

		public ErrorCodeSerializer() {
			super(ErrorCode.class);
		}

		@Override
		public void serialize(
				ErrorCode error, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
						throws IOException {
			jsonGenerator.writeStartObject();
			jsonGenerator.writeNumberField("status", error.getStatus());
			jsonGenerator.writeStringField("error_type", error.getErrorType());
			jsonGenerator.writeStringField("error_code", error.getCode());
			jsonGenerator.writeStringField("error_description", error.getDescription());
			jsonGenerator.writeNumberField("timestamp", Instant.now().toEpochMilli());
			jsonGenerator.writeEndObject();
		}
	}
}
