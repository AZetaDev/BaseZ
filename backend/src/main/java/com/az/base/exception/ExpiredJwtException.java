package com.az.base.exception;

import org.springframework.http.HttpStatus;

public class ExpiredJwtException extends CustomException {

    public ExpiredJwtException(String message, String errorDetails) {
        super(message, "ExpiredJWT errorCode", errorDetails, HttpStatus.UNAUTHORIZED);
    }
}