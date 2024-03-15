package com.az.base.exception;


import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public abstract class CustomException extends RuntimeException {

    private final String errorCode;
    private final String errorDetails;
    private final HttpStatus httpStatus;

    protected CustomException(String message, String errorCode, String errorDetails, HttpStatus httpStatus) {
        super(message);
        this.errorCode = errorCode;
        this.errorDetails = errorDetails;
        this.httpStatus = httpStatus;
    }

}
