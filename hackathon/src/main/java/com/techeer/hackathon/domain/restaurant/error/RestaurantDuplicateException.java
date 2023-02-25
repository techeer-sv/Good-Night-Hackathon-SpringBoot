package com.techeer.hackathon.domain.restaurant.error;

import com.techeer.hackathon.global.error.ErrorCode;
import com.techeer.hackathon.global.error.exceptions.BusinessException;

public class RestaurantDuplicateException extends BusinessException {
    public RestaurantDuplicateException() {
        super(ErrorCode.RESTAURANT_DUPLICATION_ERROR);
    }
}
