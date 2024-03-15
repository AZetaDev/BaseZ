package com.az.base.exception;

import org.springframework.http.HttpStatus;

public class InternalServerException extends CustomException {

    public InternalServerException(String message, String errorDetails) {
        super(message, "InternalServerException errorCode", errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}