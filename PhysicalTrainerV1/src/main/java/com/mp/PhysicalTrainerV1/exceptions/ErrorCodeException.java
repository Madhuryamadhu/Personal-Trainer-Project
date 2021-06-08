package com.mp.PhysicalTrainerV1.exceptions;

import com.mp.common.codes.ErrorCode;
import lombok.Getter;

@Getter
public class ErrorCodeException extends RuntimeException {

  private final ErrorCode errorCode;

  public ErrorCodeException(ErrorCode errorCode) {
    this.errorCode = errorCode;
  }
}
