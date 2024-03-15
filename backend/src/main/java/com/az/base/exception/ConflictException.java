package com.az.base.exception;

import org.springframework.http.HttpStatus;

public class ConflictException extends CustomException {

    public ConflictException(String message, String errorDetails) {
        super(message, "Conflict errorCode", errorDetails, HttpStatus.CONFLICT);
    }
}