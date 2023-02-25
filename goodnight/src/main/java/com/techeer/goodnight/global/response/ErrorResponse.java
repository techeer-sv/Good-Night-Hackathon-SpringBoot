package com.techeer.goodnight.global.response;
import com.techeer.goodnight.global.exception.ErrorCode;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ErrorResponse {

    private int code;
    private String message;

    @Builder
    public ErrorResponse(ErrorCode errorStatus) {
        this.code = errorStatus.getCode();
        this.message = errorStatus.getMessage();
    }
}