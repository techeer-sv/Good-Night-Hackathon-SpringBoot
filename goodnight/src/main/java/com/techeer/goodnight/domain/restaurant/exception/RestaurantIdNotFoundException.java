package com.techeer.goodnight.domain.restaurant.exception;

import com.techeer.goodnight.global.exception.ErrorCode;
import lombok.Getter;

@Getter
public class RestaurantIdNotFoundException extends RuntimeException{

    private final ErrorCode errorCode;

    public RestaurantIdNotFoundException() {
        this.errorCode = ErrorCode.RESTAURANT_ID_NOT_FOUND;
    }

}
