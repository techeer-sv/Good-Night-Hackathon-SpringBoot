package com.techeer.hackathon.domain.restaurant.error;

import com.techeer.hackathon.global.error.exceptions.BusinessException;

import static com.techeer.hackathon.global.error.ErrorCode.RESTAURANT_NOT_FOUND;

public class RestaurantNotFoundException extends BusinessException {
    public RestaurantNotFoundException() {
        super(RESTAURANT_NOT_FOUND);
    }
}
