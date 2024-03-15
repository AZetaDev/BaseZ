package com.az.base.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends CustomException {

    public BadRequestException(String message, String errorDetails) {
        super(message, "BadRequest errorCode", errorDetails, HttpStatus.BAD_REQUEST);
    }
}