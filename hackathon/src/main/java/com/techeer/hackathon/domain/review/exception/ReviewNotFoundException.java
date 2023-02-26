package com.techeer.hackathon.domain.review.exception;

import com.techeer.hackathon.global.error.ErrorCode;
import com.techeer.hackathon.global.error.exceptions.BusinessException;

public class ReviewNotFoundException extends BusinessException {
    public ReviewNotFoundException() {
        super(ErrorCode.REVIEW_NOT_FOUND);
    }
}
