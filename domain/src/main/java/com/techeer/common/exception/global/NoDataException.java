package com.techeer.common.exception.global;

import com.techeer.common.exception.ErrorCode;
import lombok.Getter;

@Getter
public class NoDataException extends RuntimeException {

  private final ErrorCode errorCode;

  public NoDataException() { this.errorCode = ErrorCode.NO_DATA_IN_DB; }

}
