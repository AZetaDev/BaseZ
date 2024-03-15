package com.az.base.exception;

import org.springframework.http.HttpStatus;

public class UnAuthorizedException extends CustomException {

    public UnAuthorizedException(String message, String errorCode, String errorDetails) {
        super(message, errorCode, errorDetails, HttpStatus.UNAUTHORIZED);
    }
}