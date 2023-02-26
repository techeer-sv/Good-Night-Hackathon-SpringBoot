package com.techeer.persistence.restaurant.exception;

import com.techeer.common.exception.ErrorCode;
import lombok.Getter;

@Getter
public class RestaurantIdNotFoundException extends RuntimeException{

    private final ErrorCode errorCode;

    public RestaurantIdNotFoundException() {
        this.errorCode = ErrorCode.RESTAURANT_ID_NOT_FOUND;
    }

}
