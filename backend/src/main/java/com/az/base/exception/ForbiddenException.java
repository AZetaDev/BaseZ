package com.az.base.exception;

import org.springframework.http.HttpStatus;

public class ForbiddenException extends CustomException {

    public ForbiddenException(String message, String errorDetails) {
        super(message, "Forbidden errorCode", errorDetails, HttpStatus.FORBIDDEN);
    }
}