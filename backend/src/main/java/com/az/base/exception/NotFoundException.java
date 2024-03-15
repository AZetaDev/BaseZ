package com.az.base.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends CustomException {

    public NotFoundException(String message, String errorDetails) {
        super(message, "NotFound errorCode", errorDetails, HttpStatus.NOT_FOUND);
    }
}
