package com.az.base.exception;

import org.springframework.http.HttpStatus;

public class NullpointerException extends CustomException {

    public NullpointerException(String message, String errorDetails) {
        super(message, "NullPointer errorCode", errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
