package com.techeer.goodnight.domain.restaurant.exception;

import com.techeer.goodnight.global.exception.BaseException;

public class NotFoundTestDataEntityException extends BaseException {

    public NotFoundTestDataEntityException(){
        super("Not Found TestData Entity");
    }
}
