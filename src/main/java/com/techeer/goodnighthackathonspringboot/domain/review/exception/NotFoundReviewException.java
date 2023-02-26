package com.techeer.goodnighthackathonspringboot.domain.review.exception;

import com.techeer.goodnighthackathonspringboot.global.error.ErrorCode;
import com.techeer.goodnighthackathonspringboot.global.exception.BusinessException;

public class NotFoundReviewException extends BusinessException {
    public NotFoundReviewException() {
        super(ErrorCode.NOT_FOUND_RESTAURANT_ENTITY);
    }
}
