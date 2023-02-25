package com.techeer.goodnight.global.exception.global;

import com.techeer.goodnight.global.exception.ErrorCode;
import lombok.Getter;

@Getter
public class BadRequestException extends RuntimeException {

    private final ErrorCode errorCode;

    public BadRequestException() { this.errorCode = ErrorCode.OMISSION_REQUIRE_PARAM; }
}