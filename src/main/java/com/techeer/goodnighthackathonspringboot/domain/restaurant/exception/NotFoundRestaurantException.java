package com.techeer.goodnighthackathonspringboot.domain.restaurant.exception;

import com.techeer.goodnighthackathonspringboot.global.error.ErrorCode;
import com.techeer.goodnighthackathonspringboot.global.exception.BusinessException;

public class NotFoundRestaurantException extends BusinessException {
    public NotFoundRestaurantException() {
        super(ErrorCode.NOT_FOUND_RESTAURANT_ENTITY);
    }
}
