package com.techeer.hackathon.domain.restaurant.error;

import com.techeer.hackathon.global.error.exceptions.BusinessException;

import static com.techeer.hackathon.global.error.ErrorCode.INVALID_CATEGORY_ERROR;

public class InvalidCategoryException extends BusinessException {
    public InvalidCategoryException() {
        super(INVALID_CATEGORY_ERROR);
    }
}
